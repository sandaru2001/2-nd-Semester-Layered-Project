package lk.ijse.Fusion.lk.ijse.Fusion.dao.custom.impl;

import lk.ijse.Fusion.lk.ijse.Fusion.Util.CRUDutil;
import lk.ijse.Fusion.lk.ijse.Fusion.dao.custom.OrderDAO;
import lk.ijse.Fusion.lk.ijse.Fusion.dto.Item;
import lk.ijse.Fusion.lk.ijse.Fusion.entity.ItemEntity;
import lk.ijse.Fusion.lk.ijse.Fusion.entity.OrderEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDAOImpl implements OrderDAO {
    @Override
    public boolean add(OrderEntity entity) throws SQLException, ClassNotFoundException {
        return CRUDutil.execute("INSERT INTO Orders VALUES (?, ?, ?)",entity.getOrderID(),entity.getOrderDate(),entity.getCustomerID());
    }

    @Override
    public boolean search(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = CRUDutil.execute("SELECT * From Orders WHERE OrderID = ? ",id);
        return rst.next();
    }

    @Override
    public boolean update(OrderEntity entity) throws SQLException, ClassNotFoundException {
        ResultSet rst = CRUDutil.execute("Update Orders set  CustomerID=?,OrderDate=?, where OrderID=?",entity.getCustomerID(),entity.getOrderDate(),entity.getOrderID());
        return rst.next();
    }

    @Override
    public boolean remove(String id) throws SQLException, ClassNotFoundException {
        return CRUDutil.execute("Delete From Orders where OrderID=?",id);
    }

    @Override
    public ArrayList<OrderEntity> loadOrderIds() throws SQLException, ClassNotFoundException {
        ArrayList<OrderEntity> allLoadIds = new ArrayList<>();
        ResultSet rst = CRUDutil.execute("SELECT * FROM Orders");
        while (rst.next()){
            OrderEntity orderEntity = new OrderEntity(rst.getString("OrderID"),rst.getString("OrderDate"),rst.getString("CustomerID"));
            allLoadIds.add(orderEntity);
        }
        return allLoadIds;
    }

    @Override
    public String getOrderId() throws SQLException, ClassNotFoundException {
        ResultSet rst = CRUDutil.execute("SELECT OrderID FROM Orders ORDER BY OrderID DESC LIMIT 1");
        return rst.next() ? String.format("OID-%03d", (Integer.parseInt(rst.getString("OrderID").replace("OID-", "")) + 1)) : "OID-001";
    }
}
