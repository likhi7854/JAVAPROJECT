package dao;

import model.Product;

import java.util.List;

public interface ProductManagement  {
    void  insertProducts(Product product);
    List<Product> getAllProduct();
    void updateProducts(Product product);
    void deleteProducts(Product product);
}
