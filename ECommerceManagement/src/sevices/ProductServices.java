package sevices;

import model.Product;

import java.util.List;

public interface ProductServices {
    void  addProduct(Product product);
    List<Product> getAllProduct();
    void updateProducts(Product product);
    void deleteProducts(int Product_id);
}
