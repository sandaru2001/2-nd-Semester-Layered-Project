package lk.ijse.Fusion.lk.ijse.Fusion.bo.custom.impl;

import lk.ijse.Fusion.lk.ijse.Fusion.bo.custom.SupplierBO;
import lk.ijse.Fusion.lk.ijse.Fusion.dao.DAOFactory;
import lk.ijse.Fusion.lk.ijse.Fusion.dao.custom.SupplierDAO;
import lk.ijse.Fusion.lk.ijse.Fusion.dto.Suppliers;
import lk.ijse.Fusion.lk.ijse.Fusion.entity.SupplierEntity;

import java.sql.SQLException;

public class SupplierBOImpl implements SupplierBO {

    SupplierDAO supplierDAO = (SupplierDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.SUPPLIER);

    @Override
    public boolean addSuppliers(Suppliers dto) throws SQLException, ClassNotFoundException {
        return supplierDAO.add(new SupplierEntity(dto.getSupplierID(),dto.getSupplierName(),dto.getSupplierEmail(),dto.getSupplierContact(),dto.getPrice(),dto.getItemCode(),dto.getAmount()));
    }

    @Override
    public boolean searchSuppliers(String id) throws SQLException, ClassNotFoundException {
        return supplierDAO.search(id);
    }

    @Override
    public boolean updateSuppliers(Suppliers dto) throws SQLException, ClassNotFoundException {
        return supplierDAO.update(new SupplierEntity(dto.getSupplierID(),dto.getSupplierName(),dto.getSupplierEmail(),dto.getSupplierContact(),dto.getPrice(),dto.getItemCode(),dto.getAmount()));
    }

    @Override
    public boolean removeSuppliers(String id) throws SQLException, ClassNotFoundException {
        return supplierDAO.remove(id);
    }
}
