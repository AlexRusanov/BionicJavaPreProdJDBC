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
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Primary
@Transactional
public class JdbcProductDao implements ProductDao {

    private RowMapper<Product> ROW_MAPPER;

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcProductDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;

        ROW_MAPPER = BeanPropertyRowMapper.newInstance(Product.class);
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
