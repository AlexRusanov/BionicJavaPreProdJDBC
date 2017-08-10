package edu.bionic.dao;

import edu.bionic.config.Profiles;
import edu.bionic.domain.Comment;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static edu.bionic.testdata.CommentFactory.getCommentsForProduct1;
import static edu.bionic.testdata.CommentFactory.getNewCommentForProduct1;

@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:spring/spring-app.xml")
@ActiveProfiles(Profiles.HSQLDB)
@Sql(scripts = "classpath:db/fillDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class CommentDaoTest {

    @Autowired
    private CommentDao commentDao;

    @Test
    public void getByProduct() throws Exception {
        List<Comment> expected = getCommentsForProduct1();
        List<Comment> actual = commentDao.getByProduct(1);

        Assert.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void save() throws Exception {
        Comment newComment = getNewCommentForProduct1();
        Comment savedComment = commentDao.save(newComment);
        newComment.setId(savedComment.getId());

        List<Comment> expected = getCommentsForProduct1();
        expected.add(newComment);

        List<Comment> actual = commentDao.getByProduct(1);

        Assert.assertEquals(expected.toString(), actual.toString());
    }

}