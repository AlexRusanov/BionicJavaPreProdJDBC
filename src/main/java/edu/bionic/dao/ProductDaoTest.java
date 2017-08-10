package edu.bionic.dao;

import edu.bionic.config.Profiles;
import edu.bionic.domain.Product;
import edu.bionic.testdata.ProductFactory;
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

@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:spring/spring-app.xml")
@ActiveProfiles(Profiles.HSQLDB)
@Sql(scripts = "classpath:db/fillDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class ProductDaoTest {

    @Autowired
    private ProductDao productDao;

    @Test
    public void getAll() throws Exception {
        List<Product> expected = ProductFactory.getAllProducts();
        List<Product> actual = productDao.getAll();

        Assert.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void getById() throws Exception {
        Product expected = ProductFactory.getProduct1();
        Product actual = productDao.getById(1).get();

        Assert.assertEquals(expected.toString(), actual.toString());
    }

}