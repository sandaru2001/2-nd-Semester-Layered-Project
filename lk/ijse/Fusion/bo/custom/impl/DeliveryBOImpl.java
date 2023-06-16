package lk.ijse.Fusion.lk.ijse.Fusion.bo.custom.impl;

import lk.ijse.Fusion.lk.ijse.Fusion.bo.custom.DeliveryBO;
import lk.ijse.Fusion.lk.ijse.Fusion.dao.DAOFactory;
import lk.ijse.Fusion.lk.ijse.Fusion.dao.custom.DeliveryDAO;
import lk.ijse.Fusion.lk.ijse.Fusion.dto.Delivery;
import lk.ijse.Fusion.lk.ijse.Fusion.entity.DeliveryEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public class DeliveryBOImpl implements DeliveryBO {

    DeliveryDAO deliveryDAO = (DeliveryDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.DELIVERY);

    @Override
    public ArrayList<Delivery> loadCustomerIds() throws SQLException, ClassNotFoundException {
        ArrayList<Delivery> allDelivery = new ArrayList<>();
        ArrayList<DeliveryEntity> all = deliveryDAO.loadCustomerIds();
        for (DeliveryEntity d:all) {
            allDelivery.add(new Delivery(d.getDeliveryID(),d.getDriverNic(),d.getDriverName(),d.getDeliveryDate(),d.getArriavalTime(),d.getStetus(),d.getOrderID()));
        }
        return allDelivery;
    }

    @Override
    public boolean addDelivery(Delivery dto) throws SQLException, ClassNotFoundException {
        return deliveryDAO.add(new DeliveryEntity(dto.getDeliveryID(), dto.getDriverNic(),dto.getDriverName(),dto.getDeliveryDate(),dto.getArriavalTime(),dto.getDeliveryFee(),dto.getStetus(),dto.getOrderID()));
    }

    @Override
    public boolean searchDelivery(String id) throws SQLException, ClassNotFoundException {
        return deliveryDAO.search(id);
    }

    @Override
    public boolean updateDelivery(Delivery dto) throws SQLException, ClassNotFoundException {
        return deliveryDAO.update(new DeliveryEntity(dto.getDeliveryID(),dto.getDriverNic(),dto.getDriverName(),dto.getDeliveryDate(),dto.getArriavalTime(),dto.getDeliveryFee(),dto.getStetus(),dto.getOrderID()));
    }

    @Override
    public boolean removeDelivery(String id) throws SQLException, ClassNotFoundException {
        return deliveryDAO.remove(id);
    }
}
