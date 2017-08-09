package edu.bionic.dao.jdbc;

import edu.bionic.dao.ProductDao;
import edu.bionic.domain.Color;
import edu.bionic.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Repository
@Primary
@Transactional
public class JdbcProductDao implements ProductDao {

    private RowMapper<Product> ROW_MAPPER;

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private SimpleJdbcInsert productInsert;

    @Autowired
    public JdbcProductDao(JdbcTemplate jdbcTemplate,
                          NamedParameterJdbcTemplate namedParameterJdbcTemplate,
                          DataSource dataSource) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;

        ROW_MAPPER = BeanPropertyRowMapper.newInstance(Product.class);
//                   (rs, rowNum) -> {
//            Product product = new Product();
//            product.setId(rs.getInt("id"));
//            product.setName(rs.getString("name"));
//            product.setPrice(rs.getBigDecimal("price"));
//            product.setColor(Color.values()[rs.getInt("color")]);
//            product.setCapacity(rs.getInt("capacity"));
//            product.setDisplay(rs.getString("display"));
//            product.setDescription(rs.getString("description"));
//            return product;
//        };
        productInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("products")
                .usingGeneratedKeyColumns("id");
    }


    @Override
    public List<Product> getAll() {
        String sql = "SELECT * FROM products";
        return jdbcTemplate.query(sql, ROW_MAPPER);
    }

    @Override
    public Optional<Product> getById(int productId) {
        String sql = "SELECT * FROM products WHERE id = ?";
        List<Product> product = jdbcTemplate.query(sql, new Object[]{productId}, ROW_MAPPER);
        return Optional.ofNullable(DataAccessUtils.singleResult(product));
    }

    List<Product> getByOrder(int orderId) {
        String sql = "SELECT * FROM products LEFT JOIN orders_products ON products.id = orders_products.product_id " +
                "WHERE orders_products.order_id = ?";
        return jdbcTemplate.query(sql, new Object[] {orderId},ROW_MAPPER);
    }
}
