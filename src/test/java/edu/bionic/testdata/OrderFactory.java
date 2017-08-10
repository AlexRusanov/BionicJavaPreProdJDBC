package edu.bionic.testdata;

import com.google.common.collect.Lists;
import edu.bionic.domain.Order;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

/**
 * Created by alexandrrusanov on 9/8/17.
 */
public class OrderFactory {

    public static Order getOrder1(){
        return new Order(
                1,
                LocalDateTime.of(2017, Month.JUNE, 1, 14, 0),
                BigDecimal.valueOf(1500),
                Lists.newArrayList(ProductFactory.getProduct(), ProductFactory.getProduct4()),
                "Олег",
                "oleg@gmail.com",
                "095664356273",
                "ул. Дорогожицкая, 1"
        );
    }

    public static Order getOrder2(){
        return new Order(
                2,
                LocalDateTime.of(2017, Month.JULY, 23, 18, 0),
                BigDecimal.valueOf(2200),
                Lists.newArrayList(ProductFactory.getProduct1(), ProductFactory.getProduct2(), ProductFactory.getProduct5()),
                "Аня",
                "anya@gmail.com",
                "095664357685",
                "ул. Артема, 30"
        );
    }

    public static List<Order> getAll (){
        return Lists.newArrayList(getOrder1(), getOrder2());
    }

    public static Order getNewOrder () {
        return new Order(
                null,
                LocalDateTime.of(2017, Month.AUGUST, 11, 11, 11),
                BigDecimal.valueOf(1600),
                Lists.newArrayList(ProductFactory.getProduct4(), ProductFactory.getProduct5()),
                "Сергей",
                "sergey@gmail.com",
                "095654357685",
                "ул. Артема, 31"
        );
    }
}
