package edu.bionic.dao;

import edu.bionic.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductDao {

    List<Product> getAll();

    Optional<Product> getById(int productId);
}
