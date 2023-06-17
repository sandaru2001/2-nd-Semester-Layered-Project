package lk.ijse.Fusion.lk.ijse.Fusion.dao.custom.impl;

import lk.ijse.Fusion.lk.ijse.Fusion.Util.CRUDutil;
import lk.ijse.Fusion.lk.ijse.Fusion.dao.custom.OrderDetailDAO;
import lk.ijse.Fusion.lk.ijse.Fusion.entity.OrderDetailEntity;

import java.sql.SQLException;

public class OrderDetailDAOImpl implements OrderDetailDAO {
    @Override
    public boolean add(OrderDetailEntity entity) throws SQLException, ClassNotFoundException {
        return CRUDutil.execute("INSERT INTO OrderDetail VALUES(?, ?, ?, ?, ?)",entity.getOrderId(),entity.getItemCode(),entity.getQty(),entity.getUnitPrice());
    }

    @Override
    public boolean search(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(OrderDetailEntity entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean remove(String id) throws SQLException, ClassNotFoundException {
        return false;
    }
}
