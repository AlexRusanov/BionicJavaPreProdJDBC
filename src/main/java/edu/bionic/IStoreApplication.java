package edu.bionic;

import com.google.common.collect.ImmutableList;
import edu.bionic.domain.Product;

import java.util.List;
import java.util.stream.Collectors;

public class IStoreApplication {

//    private static List<Product> products;
//
//    public static void main(String[] args) {
//        initProducts();
//
//        List<Product> sortedProducts = getSortedProducts();
//        printProducts(sortedProducts);
//    }
//
//    private static void initProducts() {
//        products = ImmutableList.of(
//                new Product(1, "iPhone 7", 700),
//                new Product(2, "iPhone 7 Plus", 800),
//                new Product(3, "MacBook Pro", 1500)
//        );
//    }
//
//    private static List<Product> getSortedProducts() {
//        return products
//                .stream()
//                .sorted((product1, product2) -> Double.compare(product2.getPrice(), product1.getPrice()))
//                .collect(Collectors.toList());
//    }
//
//    private static void printProducts(List<Product> products) {
//        products.forEach(product -> {
//            System.out.println(String.format("Product: %s, price - %.2f USD", product.getName(), product.getPrice()));
//        });
//    }
}
