package com.phat.e.project.Service;

import com.phat.e.project.Entity.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAllProducts();

    Product getOneProduct(String id);

    Product createProduct(Product product);

    Product updateProduct(String id, Product product);

    Product deleteProduct(String id);
}
