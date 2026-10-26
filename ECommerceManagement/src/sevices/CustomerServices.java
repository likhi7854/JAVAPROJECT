package sevices;

import model.Customer;

import java.util.List;

public interface CustomerServices {
        void insertCustomers(Customer customer);
        List<Customer>  getAllCustomers();
        void updateCustomers(Customer customer);
        void logOut(int customer_id);
}
