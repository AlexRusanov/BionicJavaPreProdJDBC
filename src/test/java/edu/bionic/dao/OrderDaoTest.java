package edu.bionic.dao;

import edu.bionic.config.Profiles;
import edu.bionic.domain.Order;
import edu.bionic.testdata.OrderFactory;
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

import static org.junit.Assert.*;

/**
 * Created by alexandrrusanov on 9/8/17.
 */

@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:spring/spring-app.xml")
@ActiveProfiles(Profiles.POSTGRES)
@Sql(scripts = "classpath:db/fillDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class OrderDaoTest {

    @Autowired
    private OrderDao orderDao;

    @Test
    public void getAll() throws Exception {
        List<Order> expected = OrderFactory.getAll();
        List<Order> actual = orderDao.getAll();

        Assert.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void save() throws Exception {
        Order newOrder = OrderFactory.getNewOrder();
        Order savedOrder = orderDao.save(newOrder);
        newOrder.setId(savedOrder.getId());

        List<Order> expected = OrderFactory.getAll();
        expected.add(newOrder);
        List<Order> actual = orderDao.getAll();

        Assert.assertEquals(expected.toString(), actual.toString());

    }

}