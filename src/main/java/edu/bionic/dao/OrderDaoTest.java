package edu.bionic.dao;

import edu.bionic.config.Profiles;
import edu.bionic.domain.Order;
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

import static edu.bionic.testdata.OrderFactory.getAllOrders;
import static edu.bionic.testdata.OrderFactory.getNewOrder;

@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:spring/spring-app.xml")
@ActiveProfiles(Profiles.HSQLDB)
@Sql(scripts = "classpath:db/fillDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class OrderDaoTest {

    @Autowired
    private OrderDao orderDao;

    @Test
    public void getAll() throws Exception {
        List<Order> expected = getAllOrders();
        List<Order> actual = orderDao.getAll();

        Assert.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void save() throws Exception {
        Order newOrder = getNewOrder();
        Order savedOrder = orderDao.save(newOrder);
        newOrder.setId(savedOrder.getId());

        List<Order> expected = getAllOrders();
        expected.add(newOrder);

        List<Order> actual = orderDao.getAll();

        Assert.assertEquals(expected.toString(), actual.toString());
    }

}