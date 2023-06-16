package lk.ijse.Fusion.lk.ijse.Fusion.entity;

public class CustomerEntity {
    private String CustomerID;
    private String CustomerNIC;
    private String CustomerName;
    private String Address;
    private String PhoneNumber;
    private String Email;

    public CustomerEntity() {
    }

    public CustomerEntity(String customerID, String customerNIC, String customerName, String address, String phoneNumber, String email) {
        CustomerID = customerID;
        CustomerNIC = customerNIC;
        CustomerName = customerName;
        Address = address;
        PhoneNumber = phoneNumber;
        Email = email;
    }

    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String customerID) {
        CustomerID = customerID;
    }

    public String getCustomerNIC() {
        return CustomerNIC;
    }

    public void setCustomerNIC(String customerNIC) {
        CustomerNIC = customerNIC;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    @Override
    public String toString() {
        return "CustomerEntity{" +
                "CustomerID='" + CustomerID + '\'' +
                ", CustomerNIC='" + CustomerNIC + '\'' +
                ", CustomerName='" + CustomerName + '\'' +
                ", Address='" + Address + '\'' +
                ", PhoneNumber='" + PhoneNumber + '\'' +
                ", Email='" + Email + '\'' +
                '}';
    }
}
