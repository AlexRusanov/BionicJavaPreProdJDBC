package edu.bionic.service;

import edu.bionic.domain.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAll();

    Product getById(int productId);
}
