package edu.bionic.dao.jdbc;

import edu.bionic.dao.CommentDao;
import edu.bionic.domain.Comment;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
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
public class JdbcCommentDao implements CommentDao {

    private RowMapper<Comment> ROW_MAPPER;

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private SimpleJdbcInsert commentInsert;

    public JdbcCommentDao(JdbcTemplate jdbcTemplate,
                          NamedParameterJdbcTemplate namedParameterJdbcTemplate,
                          DataSource dataSource) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;

        ROW_MAPPER = BeanPropertyRowMapper.newInstance(Comment.class);
//                     (rs, rowNum) -> {
//            Comment comment = new Comment();
//            comment.setId(rs.getInt("id"));
//            comment.setProductId(rs.getInt("product_id"));
//            comment.setAuthor(rs.getString("author"));
//            comment.setDateTime(rs.getTimestamp("datetime").toLocalDateTime());
//            comment.setText(rs.getString("text"));
//            comment.setRating(rs.getInt("rating"));
//            return comment;
//        };
        commentInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("comments")
                .usingGeneratedKeyColumns("id");
    }

    @Override
    public List<Comment> getByProduct(int productId) {
        String sql = "SELECT * FROM comments WHERE product_id = ?";
        return jdbcTemplate.query(sql, new Object[]{productId},ROW_MAPPER);
    }

    @Override
    public Comment save(Comment comment) {
        SqlParameterSource commentParameterSource = new BeanPropertySqlParameterSource(comment);

//        Map<String, Object> parameters = new HashMap<>();
//        parameters.put("product_id", comment.getProductId());
//        parameters.put("author", comment.getAuthor());
//        parameters.put("datetime", comment.getDateTime());
//        parameters.put("text", comment.getText());
//        parameters.put("rating", comment.getRating());
        Number newId = commentInsert.executeAndReturnKey(commentParameterSource);

        comment.setId(newId.intValue());
        return comment;
    }
}
