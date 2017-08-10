package edu.bionic.dao;

import edu.bionic.domain.Comment;
import edu.bionic.testdata.CommentFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by alexandrrusanov on 9/8/17.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:spring/spring-app.xml")
@Sql(scripts = "classpath:db/fillDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class CommentDaoTest {

    @Autowired
    private CommentDao commentDao;

    @Test
    public void getByProduct() throws Exception {
        Comment expected = CommentFactory.getComment1();
        Comment actual = commentDao.getByProduct()
    }

    @Test
    public void save() throws Exception {
        Comment newComment = CommentFactory.getNewComment();
        Comment savedComment = commentDao.save(newComment);
        newComment.setId(savedComment.getId());

        List<Comment> expected = CommentFactory.getAll();
        expected.add(newComment);
        List<Comment> actual = commentDao.
    }

}