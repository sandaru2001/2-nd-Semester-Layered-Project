package lk.ijse.Fusion.lk.ijse.Fusion.dao.custom.impl;

import lk.ijse.Fusion.lk.ijse.Fusion.Util.CRUDutil;
import lk.ijse.Fusion.lk.ijse.Fusion.dao.custom.DeliveryDAO;
import lk.ijse.Fusion.lk.ijse.Fusion.entity.DeliveryEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DeliveryDAOImpl implements DeliveryDAO {
    @Override
    public boolean add(DeliveryEntity entity) throws SQLException, ClassNotFoundException {
        return CRUDutil.execute("INSERT INTO fusiontech.delivery VALUES (?, ?, ?, ?, ?, ?, ? ,? )",entity.getDeliveryID(),entity.getDriverNic(),entity.getDriverName(),entity.getDeliveryDate(),entity.getArriavalTime(),entity.getDeliveryFee(),entity.getStetus(),entity.getOrderID());
    }

    @Override
    public boolean search(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = CRUDutil.execute("SELECT * From fusiontech.Delivery WHERE DeliveryID = ?",id);
        return rst.next();
    }

    @Override
    public boolean update(DeliveryEntity entity) throws SQLException, ClassNotFoundException {
        return CRUDutil.execute("Update delivery set   OrderID=?, Stetus=?, DeliveryFee=?, ArriavalTime=?, DeliveryDate=? ,DriverName=?, DriverNic=? where DeliveryID=?",entity.getDeliveryID(),entity.getDriverNic(),entity.getDriverName(),entity.getDeliveryDate(),entity.getArriavalTime(),entity.getDeliveryFee(),entity.getStetus(),entity.getOrderID());
    }

    @Override
    public boolean remove(String id) throws SQLException, ClassNotFoundException {
        return CRUDutil.execute("Delete From delivery where DeliveryID =?",id);
    }

    @Override
    public ArrayList<DeliveryEntity> loadCustomerIds() throws SQLException, ClassNotFoundException {
        ArrayList<DeliveryEntity> allDelivery = new ArrayList<>();
        ResultSet rst = CRUDutil.execute("SELECT * FROM  fusiontech.Delivery");
        while (rst.next()){
            DeliveryEntity deliveryEntity = new DeliveryEntity(rst.getString("DeliveryID"),rst.getString("DriverNic"),rst.getString("DriverName"),rst.getString("DeliveryDate"),rst.getString("ArriavalTime"),rst.getString("DeliveryFee"),rst.getString("Stetus"),rst.getString("OrderID"));
            allDelivery.add(deliveryEntity);
        }
        return allDelivery;
    }
}
