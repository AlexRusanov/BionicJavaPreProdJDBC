package edu.bionic.dao.jdbc;

import edu.bionic.dao.OrderDao;
import edu.bionic.domain.Order;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Primary
@Transactional
public class JdbcOrderDao implements OrderDao {

    private RowMapper<Order> ROW_MAPPER;

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameter;
    private SimpleJdbcInsert orderInsert;
    private JdbcProductDao jdbcProductDao;

    public JdbcOrderDao(JdbcTemplate jdbcTemplate,
                        NamedParameterJdbcTemplate namedJdbcTemplate,
                        DataSource dataSource,
                        JdbcProductDao jdbcOrderDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.jdbcProductDao = jdbcOrderDao;
        this.namedParameter = namedJdbcTemplate;

        ROW_MAPPER = (rs, rowNum) -> {
            Order order = new Order();
            order.setId(rs.getInt("id"));
            order.setTotalAmount(rs.getBigDecimal("total_amount"));
            order.setDateTime(rs.getTimestamp("datetime").toLocalDateTime());
            order.setName(rs.getString("name"));
            order.setEmail(rs.getString("email"));
            order.setPhone(rs.getString("phone"));
            order.setAddress(rs.getString("address"));
            return order;
        };
        orderInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("orders")
                .usingGeneratedKeyColumns("id");
    }

    @Override
    public List<Order> getAll() {
        String sql = "SELECT * FROM orders";
        List<Order> orders = jdbcTemplate.query(sql, ROW_MAPPER);
        orders.forEach(order -> order.setProducts(jdbcProductDao.getByOrder(order.getId())));
        return orders;
    }

    @Override
    public Order save(Order order) {
        //Map<String, Object> parameters = new HashMap<>();
        //parameters.put("total_amount", order.getTotalAmount());
        //parameters.put("datetime", order.getDateTime());
        //parameters.put("name", order.getName());
        //parameters.put("email", order.getEmail());
        //parameters.put("phone", order.getPhone());
        //parameters.put("address", order.getAddress());
        BeanPropertySqlParameterSource parameters = new BeanPropertySqlParameterSource(order);
        Number newId = orderInsert.executeAndReturnKey(parameters);
        order.setId(newId.intValue());

        String sql = "INSERT INTO orders_products (order_id, product_id) VALUES (:order_id, :product_id)";
        order.getProducts().forEach(product -> {
            //this.jdbcTemplate.update(sql, order.getId(), product.getId());
            MapSqlParameterSource parameterSource = new MapSqlParameterSource();
            parameterSource.addValue("order_id", order.getId());
            parameterSource.addValue("product_id", product.getId());
            namedParameter.update(sql, parameterSource);
        });

        return order;
    }
}
