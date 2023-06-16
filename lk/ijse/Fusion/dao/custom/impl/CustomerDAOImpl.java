package lk.ijse.Fusion.lk.ijse.Fusion.dao.custom.impl;

import lk.ijse.Fusion.lk.ijse.Fusion.Util.CRUDutil;
import lk.ijse.Fusion.lk.ijse.Fusion.dao.custom.CustomerDAO;
import lk.ijse.Fusion.lk.ijse.Fusion.dto.Customer;
import lk.ijse.Fusion.lk.ijse.Fusion.entity.CustomerEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public boolean add(CustomerEntity entity) throws SQLException, ClassNotFoundException {
        return CRUDutil.execute("INSERT INTO Customer VALUES (?, ?, ?, ?, ?, ?)",entity.getCustomerID(),entity.getCustomerNIC(),entity.getCustomerName(),entity.getAddress(),entity.getPhoneNumber(),entity.getEmail());
    }

    @Override
    public boolean search(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = CRUDutil.execute("SELECT * From Customer WHERE CustomerID = ? ",id);
        return rst.next();
    }

    @Override
    public boolean update(CustomerEntity entity) throws SQLException, ClassNotFoundException {
        return CRUDutil.execute("Update Customer set Email=?, PhoneNumber=?, Address=? ,CustomerName=?, CustomerNIC=? where CustomerID=?",entity.getEmail(),entity.getPhoneNumber(),entity.getAddress(),entity.getCustomerName(),entity.getCustomerNIC(),entity.getCustomerID());
    }

    @Override
    public boolean remove(String id) throws SQLException, ClassNotFoundException {
        return CRUDutil.execute("Delete From Customer where CustomerID= ?",id);
    }

    @Override
    public ArrayList<CustomerEntity> loadCustomerIds() throws SQLException, ClassNotFoundException {
        ArrayList<CustomerEntity> allCustomer = new ArrayList<>();
        ResultSet rst = CRUDutil.execute("SELECT CustomerID FROM Customer");
        while (rst.next()){
            CustomerEntity customerEntity = new CustomerEntity(rst.getString("CustomerID"),rst.getString("CustomerName"),rst.getString("CustomerNIC"),rst.getString("Address"),rst.getString("PhoneNumber"),rst.getString("Email"));
            allCustomer.add(customerEntity);
        }
        return allCustomer;
    }

    @Override
    public CustomerEntity getCustomer(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = CRUDutil.execute("select * from Customer where CustomerID = ?",id);
        rst.next();
        return new CustomerEntity(id + "",rst.getString("CustomerName"),rst.getString("CustomerNIC"),rst.getString("Address"),rst.getString("PhoneNumber"),rst.getString("Email"));
    }


}
