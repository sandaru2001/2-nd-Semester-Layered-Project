package lk.ijse.Fusion.lk.ijse.Fusion.dao.custom;

import lk.ijse.Fusion.lk.ijse.Fusion.dao.CrudDAO;
import lk.ijse.Fusion.lk.ijse.Fusion.entity.CustomerEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerDAO extends CrudDAO<CustomerEntity> {
    public ArrayList<CustomerEntity> loadCustomerIds() throws SQLException, ClassNotFoundException;

    public CustomerEntity getCustomer(String id) throws SQLException, ClassNotFoundException;
}
