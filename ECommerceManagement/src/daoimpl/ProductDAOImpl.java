package daoimpl;

import dao.ProductManagement;
import database.Database;
import model.Product;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductManagement {
    @Override
    public void insertProducts(Product product) {
          try {
              String sql = "insert into product(product_name, description,price,stock_quantity,status) values (?,?,?,?,?)";
              Connection con = Database.getConnection();
              PreparedStatement ps = con.prepareStatement(sql);
              ps.setString(1,product.getProduct_name());
              ps.setString(2,product.getDescription());
              ps.setDouble(3,product.getPrice());
              ps.setInt(4,product.getStock_quantity());
              ps.setString(5,product.getStatus());

              int rows = ps.executeUpdate();
              if (rows > 0) {
                  System.out.println("Product inserted successfully.");
              }

              ps.close();
              con.close();

          }
          catch (Exception e){
              e.printStackTrace();
          }

    }

    @Override
    public List<Product> getAllProduct() {
        List<Product> products = new ArrayList<>();
        try {
            String sql = "select * from product";
            Connection con = Database.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int product_id =rs.getInt("product_id");
                String product_name=rs.getString("product_name");
                String description = rs.getString("description");
                double price = rs.getDouble("price");
                int stock_quantity = rs.getInt("stock_quantity");
                String status =  rs.getString("status");
                Product product = new Product(product_name, description,price,stock_quantity,status);
                product.setProduct_id(product_id);
                products.add(product);
            }
            rs.close();
            ps.close();
            con.close();
        }
        catch (Exception e ){
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public void updateProducts(Product product) {
        try {
            String sql = "update product set product_name =?, description=?,price=?,stock_quantity=?,status=? where  product_id = ?";
            Connection con = Database.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,product.getProduct_name());
            ps.setString(2,product.getDescription());
            ps.setDouble(3,product.getPrice());
            ps.setInt(4,product.getStock_quantity());
            ps.setString(5,product.getStatus());
            ps.setInt(6, product.getProduct_id());

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Product Updated successfully.");
            }
            else{
                System.out.println("Product ID not found.");
            }

            ps.close();
            con.close();

        }
        catch (Exception e ){
            e.printStackTrace();
        }

    }

    @Override
    public void deleteProducts(int product_id) {
        try {
            String sql = "delete  from product where  product_id = ?";
            Connection con = Database.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, product_id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Product deleted successfully.");
            } else {
                System.out.println("Product ID not found.");
            }

            ps.close();
            con.close();

        }
        catch (Exception e ){
            e.printStackTrace();
        }

    }
}
