package lk.ijse.Fusion.lk.ijse.Fusion.model;



import lk.ijse.Fusion.lk.ijse.Fusion.Util.CRUDutil;
import lk.ijse.Fusion.lk.ijse.Fusion.dto.OrderDetail;
import lk.ijse.Fusion.lk.ijse.Fusion.dto.Orders;

import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDetailModel {
    public static boolean saveOrderDetails(ArrayList<OrderDetail> orderDetails) throws SQLException, ClassNotFoundException {
        for (OrderDetail orderDetail : orderDetails) {
            if (!save(orderDetail)) {
                return false;
            }
        }
        return true;
    }



    private static boolean save(OrderDetail orderDetail) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO OrderDetail VALUES(?, ?, ?, ?, ?)";
        return CRUDutil.execute(sql, orderDetail.getOrderId(), orderDetail.getItemCode(), orderDetail.getQty(),orderDetail.getDescriptions(), orderDetail.getUnitPrice());
    }


    private static boolean save(Orders orders) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO OrderDetail VALUES(?, ?, ?, ?, ?)";
        return CRUDutil.execute(sql, orders.getOrderID(),orders.getCustomerID(), orders.getOrderName(), orders.getOrderDate(), orders.getOrderQty());
    }

}