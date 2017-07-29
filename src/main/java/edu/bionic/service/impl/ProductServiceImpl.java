package edu.bionic.service.impl;

import edu.bionic.dao.ProductDao;
import edu.bionic.domain.Product;
import edu.bionic.service.ProductService;
import edu.bionic.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductDao productDao;

    @Autowired
    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public List<Product> getAll() {
        return productDao.getAll()
                .stream()
                .sorted(Comparator.comparing(Product::getName))
                .collect(Collectors.toList());
    }

    @Override
    public Product getById(int productId) {
        return productDao.getById(productId).
                orElseThrow(() -> new NotFoundException(String.format("Продукт с id=%d не найден", productId)));
    }
}
