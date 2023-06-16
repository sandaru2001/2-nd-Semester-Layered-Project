package lk.ijse.Fusion.lk.ijse.Fusion.dao.custom;

import lk.ijse.Fusion.lk.ijse.Fusion.dao.CrudDAO;
import lk.ijse.Fusion.lk.ijse.Fusion.entity.DeliveryEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DeliveryDAO extends CrudDAO<DeliveryEntity> {
    public ArrayList<DeliveryEntity> loadCustomerIds() throws SQLException, ClassNotFoundException;
}
