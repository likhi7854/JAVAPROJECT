package daoimpl;

import dao.CustomerManagement;
import database.Database;
import model.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerManagement {

    @Override
    public void customerLogin(Customer customer) {

        try {
            String sql = "insert into customer(customer_name, email,phone,password_hash,address ) values (?,?,?,?,?)";
            Connection con = Database.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,customer.getCustomerName());
            ps.setString(2,customer.getEmail());
            ps.setString(3,customer.getPhone());
            ps.setString(4,customer.getPasswordHash());
            ps.setString(5,customer.getAddress());

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Customer inserted successfully.");
            }

            ps.close();
            con.close();

        }
        catch (Exception e){
            e.printStackTrace();
        }


    }

    @Override
    public List<Customer> getAllCustomerDetails(Customer customer) {
        List<Customer> customers = new ArrayList<>();
        try {
            String sql = "select * from customer";
            Connection con = Database.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int customerId =rs.getInt("customer_id");
                String customerName=rs.getString("customer_name");
                String email = rs.getString("email");
                String phoneNum = rs.getString("phone");
                String password = rs.getString("password_hash");
                String address =  rs.getString("address");
                customer = new Customer(customerId,customerName,email,phoneNum,password,address);
                customer.setCustomerId(customerId);
                customers.add(customer);
            }
            rs.close();
            ps.close();
            con.close();
        }
        catch (Exception e ){
            e.printStackTrace();
        }
        return customers;
    }


    @Override
    public void deleteCustomer(int id) {

        try {
            String sql = "delete  from customer where  customer_id = ?";
            Connection con = Database.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Customer deleted successfully.");
            } else {
                System.out.println("Customer ID not found.");
            }

            ps.close();
            con.close();

        }
        catch (Exception e ){
            e.printStackTrace();
        }


    }

    @Override
    public void updateCustomer(Customer customer) {

        try {
            String sql = "update customer set customer_name=?,email=?,phoneNum=?,password=?,address=? where  customer_id = ?";
            Connection con = Database.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,customer.getCustomerName());
            ps.setString(2,customer.getEmail());
            ps.setString(3,customer.getPhone());
            ps.setString(4,customer.getPasswordHash());
            ps.setString(5,customer.getAddress());
            ps.setInt(6,customer.getCustomerId());

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Customer Updated successfully.");
            } else {
                System.out.println("Customer ID not found.");
            }

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
