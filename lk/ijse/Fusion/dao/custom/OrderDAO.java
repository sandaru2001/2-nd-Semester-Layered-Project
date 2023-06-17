package lk.ijse.Fusion.lk.ijse.Fusion.dao.custom;

import lk.ijse.Fusion.lk.ijse.Fusion.dao.CrudDAO;
import lk.ijse.Fusion.lk.ijse.Fusion.entity.OrderEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public interface OrderDAO extends CrudDAO<OrderEntity> {
    public ArrayList<OrderEntity> loadOrderIds() throws SQLException, ClassNotFoundException;

    public  String getOrderId() throws SQLException, ClassNotFoundException;
}
