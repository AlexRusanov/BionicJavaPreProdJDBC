package edu.bionic.testdata;

import com.google.common.collect.Lists;
import edu.bionic.domain.Color;
import edu.bionic.domain.Product;

import java.math.BigDecimal;
import java.util.List;

public class ProductFactory {

    public static Product getProduct1() {
        return new Product(
                1,
                "iPhone 7",
                BigDecimal.valueOf(700),
                Color.BLACK,
                64,
                "4,7 inch",
                null
        );
    }

    public static Product getProduct2() {
        return new Product(
                2,
                "iPhone 7",
                BigDecimal.valueOf(700),
                Color.WHITE,
                128,
                "4,7 inch",
                null
        );
    }

    public static Product getProduct3() {
        return new Product(
                3,
                "iPhone 7",
                BigDecimal.valueOf(700),
                Color.GRAY,
                256,
                "4,7 inch",
                null
        );
    }

    public static Product getProduct4() {
        return new Product(
                4,
                "iPhone 7 Plus",
                BigDecimal.valueOf(800),
                Color.BLACK,
                256,
                "5,5 inch",
                null
        );
    }

    public static Product getProduct5() {
        return new Product(
                5,
                "iPhone 7 Plus",
                BigDecimal.valueOf(800),
                Color.GRAY,
                64,
                "5,5 inch",
                null
        );
    }

    public static Product getProduct6() {
        return new Product(
                6,
                "iPhone 7 Plus",
                BigDecimal.valueOf(800),
                Color.WHITE,
                128,
                "5,5 inch",
                null
        );
    }

    public static List<Product> getAllProducts() {
        return Lists.newArrayList(
                getProduct1(),
                getProduct2(),
                getProduct3(),
                getProduct4(),
                getProduct5(),
                getProduct6()
        );
    }
}
