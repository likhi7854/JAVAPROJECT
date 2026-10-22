package serviceimpl;

import model.Product;
import sevices.ProductServices;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

public class ProductServiceImpl implements ProductServices {
    @Override
    public void addProduct(Product product) {

    }

    @Override
    public List<Product> getAllProduct() {
        return List.of();
    }

    @Override
    public void updateProducts(Product product) {

    }

    @Override
    public void deleteProducts(int Product_id) {

    }
}
