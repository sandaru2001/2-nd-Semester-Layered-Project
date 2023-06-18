package lk.ijse.Fusion.lk.ijse.Fusion.dao.custom.impl;

import lk.ijse.Fusion.lk.ijse.Fusion.Util.CRUDutil;
import lk.ijse.Fusion.lk.ijse.Fusion.dao.custom.SupplierDAO;
import lk.ijse.Fusion.lk.ijse.Fusion.entity.SupplierEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SupplierDAOImpl implements SupplierDAO {

    @Override
    public boolean add(SupplierEntity entity) throws SQLException, ClassNotFoundException {
        return CRUDutil.execute("INSERT INTO suppliers VALUES (?, ?, ?, ?, ?, ?, ?)",entity.getSupplierID(),entity.getSupplierName(),entity.getSupplierEmail(),entity.getSupplierContact(),entity.getItemCode(),entity.getPrice(),entity.getAmount());
    }

    @Override
    public boolean search(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = CRUDutil.execute("SELECT * From suppliers WHERE SupplierID = ? ",id);
        return rst.next();
    }

    @Override
    public boolean update(SupplierEntity entity) throws SQLException, ClassNotFoundException {
        return CRUDutil.execute("Update suppliers set Amount=?,ItemCode=?, Price=?, SupplierContact=? ,SupplierEmail=?, SupplierName=? where SupplierID=?",entity.getAmount(),entity.getItemCode(),entity.getPrice(),entity.getSupplierContact(),entity.getSupplierEmail(),entity.getSupplierName(),entity.getSupplierID());
    }

    @Override
    public boolean remove(String id) throws SQLException, ClassNotFoundException {
        return CRUDutil.execute("Delete From suppliers where SupplierID=?",id);
    }
}

