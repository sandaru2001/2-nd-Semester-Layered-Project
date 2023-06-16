package lk.ijse.Fusion.lk.ijse.Fusion.bo.custom;

import lk.ijse.Fusion.lk.ijse.Fusion.bo.SuperBO;
import lk.ijse.Fusion.lk.ijse.Fusion.dto.Customer;


import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerBO extends SuperBO {
    public ArrayList<Customer> loadCustomerIds() throws SQLException, ClassNotFoundException;

    public boolean addCustomer(Customer dto) throws SQLException, ClassNotFoundException;

    public boolean searchCustomer(String id) throws SQLException, ClassNotFoundException;

    public boolean updateCustomer(Customer dto) throws SQLException, ClassNotFoundException;

    public boolean removeCustomer(String id) throws SQLException, ClassNotFoundException;
}
