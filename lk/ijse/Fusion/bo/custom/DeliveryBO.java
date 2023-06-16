package lk.ijse.Fusion.lk.ijse.Fusion.bo.custom;

import lk.ijse.Fusion.lk.ijse.Fusion.bo.SuperBO;
import lk.ijse.Fusion.lk.ijse.Fusion.dto.Delivery;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DeliveryBO extends SuperBO {
    public ArrayList<Delivery> loadCustomerIds() throws SQLException, ClassNotFoundException;

    public boolean addDelivery(Delivery dto) throws SQLException, ClassNotFoundException;

    public boolean searchDelivery(String id) throws SQLException, ClassNotFoundException;

    public boolean updateDelivery(Delivery dto) throws SQLException, ClassNotFoundException;

    public boolean removeDelivery(String id) throws SQLException, ClassNotFoundException;
}
