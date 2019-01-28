package ru.kogut.enterprise.services;

import ru.kogut.enterprise.models.Product;

import java.util.List;

public interface ProductServiceInt {

    void saveProduct(Product product);
    Product getProductById(String id);
    List<Product> getAllProducts();
    void updateProduct(Product product);
    void deleteProduct(Product product);

}
