package lk.ijse.Fusion.lk.ijse.Fusion.dao.custom;

import lk.ijse.Fusion.lk.ijse.Fusion.dao.CrudDAO;
import lk.ijse.Fusion.lk.ijse.Fusion.dto.OrderDetail;
import lk.ijse.Fusion.lk.ijse.Fusion.entity.ItemEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemDAO extends CrudDAO<ItemEntity> {
    public ArrayList<ItemEntity> loadItemIds() throws SQLException, ClassNotFoundException;

    public ArrayList<ItemEntity> getItemList() throws SQLException, ClassNotFoundException;

    public ItemEntity getItem(String code) throws SQLException, ClassNotFoundException;

    public ArrayList<String> loaditemIds() throws SQLException, ClassNotFoundException;

    public ArrayList<String> loadItemCodes() throws SQLException, ClassNotFoundException;

    public ArrayList<String> loadItemTypes() throws SQLException, ClassNotFoundException;

    public ItemEntity searchType(String ItemType) throws SQLException, ClassNotFoundException;

    public boolean updateQty(String itemCode,int qty) throws SQLException, ClassNotFoundException;

    public boolean updateQty(ArrayList<OrderDetail> orderDetails) throws SQLException, ClassNotFoundException;
}
