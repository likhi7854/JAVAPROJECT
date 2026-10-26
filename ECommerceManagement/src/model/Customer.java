package model;

public class Customer {
    private  int customerId  ;
    private String customerName ;
    private String email ;
    private String phone;
    private String passwordHash ;
    private String address ;

    public void setCustomerId(int customerId){
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Customer(int customerId, String customerName, String email, String phone, String passwordHash, String address) {
        this.customerName = customerName;
        this.email = email;
        this.phone = phone;
        this.passwordHash = passwordHash;
        this.address = address;
    }

    public int getCustomerId() {
        return customerId;
    }
}
