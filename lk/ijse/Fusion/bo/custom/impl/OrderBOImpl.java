package lk.ijse.Fusion.lk.ijse.Fusion.bo.custom.impl;

import lk.ijse.Fusion.lk.ijse.Fusion.bo.custom.OrderBO;
import lk.ijse.Fusion.lk.ijse.Fusion.dao.DAOFactory;
import lk.ijse.Fusion.lk.ijse.Fusion.dao.custom.OrderDAO;
import lk.ijse.Fusion.lk.ijse.Fusion.dto.Orders;
import lk.ijse.Fusion.lk.ijse.Fusion.entity.OrderEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public class OrderBOImpl implements OrderBO {

    OrderDAO orderDAO = (OrderDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ORDER);

    @Override
    public ArrayList<Orders> loadOrdersIds() throws SQLException, ClassNotFoundException {
        ArrayList<Orders> allOrders = new ArrayList<>();
        ArrayList<OrderEntity> all = orderDAO.loadOrderIds();
        for (OrderEntity o:all) {
            allOrders.add(new Orders(o.getOrderID(),o.getOrderDate(),o.getCustomerID()));
        }
        return allOrders;
    }

    @Override
    public boolean addOrders(Orders dto) throws SQLException, ClassNotFoundException {
        return orderDAO.add(new OrderEntity(dto.getOrderID(), dto.getOrderDate(), dto.getCustomerID()));
    }

    @Override
    public boolean searchOrders(String id) throws SQLException, ClassNotFoundException {
        return orderDAO.search(id);
    }

    @Override
    public boolean updateOrders(Orders dto) throws SQLException, ClassNotFoundException {
        return orderDAO.update(new OrderEntity(dto.getOrderID(), dto.getOrderDate(), dto.getCustomerID()));
    }

    @Override
    public boolean removeOrders(String id) throws SQLException, ClassNotFoundException {
        return orderDAO.remove(id);
    }
}
