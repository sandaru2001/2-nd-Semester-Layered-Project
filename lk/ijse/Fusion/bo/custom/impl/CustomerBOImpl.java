package lk.ijse.Fusion.lk.ijse.Fusion.bo.custom.impl;

import lk.ijse.Fusion.lk.ijse.Fusion.bo.custom.CustomerBO;
import lk.ijse.Fusion.lk.ijse.Fusion.dao.DAOFactory;
import lk.ijse.Fusion.lk.ijse.Fusion.dao.custom.CustomerDAO;
import lk.ijse.Fusion.lk.ijse.Fusion.dto.Customer;
import lk.ijse.Fusion.lk.ijse.Fusion.entity.CustomerEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO {

    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    @Override
    public ArrayList<Customer> loadCustomerIds() throws SQLException, ClassNotFoundException {
        ArrayList<Customer> allCustomer = new ArrayList<>();
        ArrayList<CustomerEntity> all = customerDAO.loadCustomerIds();
        for (CustomerEntity c:all) {
            allCustomer.add(new Customer(c.getCustomerID(),c.getCustomerNIC(),c.getCustomerName(),c.getAddress(),c.getPhoneNumber(),c.getEmail()));
        }
        return allCustomer;
    }


    @Override
    public boolean addCustomer(Customer dto) throws SQLException, ClassNotFoundException {
        return customerDAO.add(new CustomerEntity(dto.getCustomerID(), dto.getCustomerNIC(), dto.getCustomerName(), dto.getAddress(), dto.getPhoneNumber(), dto.getEmail()));
    }

    @Override
    public boolean searchCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.search(id);
    }

    @Override
    public boolean updateCustomer(Customer dto) throws SQLException, ClassNotFoundException {
        return customerDAO.update(new CustomerEntity(dto.getCustomerID(),dto.getCustomerNIC(), dto.getCustomerName(), dto.getAddress(), dto.getPhoneNumber(), dto.getEmail()));
    }

    @Override
    public boolean removeCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.remove(id);
    }
}
