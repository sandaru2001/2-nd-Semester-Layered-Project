package lk.ijse.Fusion.lk.ijse.Fusion.bo.custom;

import lk.ijse.Fusion.lk.ijse.Fusion.bo.SuperBO;
import lk.ijse.Fusion.lk.ijse.Fusion.dto.OrderDetail;

import java.sql.SQLException;

public interface OrderDetailBO extends SuperBO {
    public boolean addItem(OrderDetail dto) throws SQLException, ClassNotFoundException;
}
