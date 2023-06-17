package lk.ijse.Fusion.lk.ijse.Fusion.bo.custom;

import lk.ijse.Fusion.lk.ijse.Fusion.bo.SuperBO;
import lk.ijse.Fusion.lk.ijse.Fusion.dto.Item;
import lk.ijse.Fusion.lk.ijse.Fusion.dto.Orders;

import java.sql.SQLException;
import java.util.ArrayList;

public interface OrderBO extends SuperBO {
    public ArrayList<Orders> loadOrdersIds() throws SQLException, ClassNotFoundException;

    public boolean addOrders(Orders dto) throws SQLException, ClassNotFoundException;

    public boolean searchOrders(String id) throws SQLException, ClassNotFoundException;

    public boolean updateOrders(Orders dto) throws SQLException, ClassNotFoundException;

    public boolean removeOrders(String id) throws SQLException, ClassNotFoundException;
}
