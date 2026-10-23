package dao;

import model.Customer;

import java.util.List;

public interface CustomerManagement {
    void  customerLogin(Customer customer);
    List<Customer> getAllCustomerDetails(Customer customer);
    void deleteCustomer(int id);
    void  updateCustomer(Customer customer);


}
