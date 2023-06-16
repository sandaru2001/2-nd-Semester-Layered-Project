package lk.ijse.Fusion.lk.ijse.Fusion.dao.custom.impl;

import lk.ijse.Fusion.lk.ijse.Fusion.Util.CRUDutil;
import lk.ijse.Fusion.lk.ijse.Fusion.dao.custom.ItemDAO;
import lk.ijse.Fusion.lk.ijse.Fusion.dto.OrderDetail;
import lk.ijse.Fusion.lk.ijse.Fusion.entity.ItemEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemDAOImpl implements ItemDAO {
    @Override
    public boolean add(ItemEntity entity) throws SQLException, ClassNotFoundException {
        return CRUDutil.execute("INSERT INTO Item VALUES (?, ?, ?, ?, ?, ?)",entity.getItemCode(),entity.getItemName(),entity.getItemDescription(),entity.getItemPrice(),entity.getQtyOnHand(),entity.getItemType());
    }

    @Override
    public boolean search(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = CRUDutil.execute("SELECT * From Item WHERE ItemCode = ?",id);
        return rst.next();
    }

    @Override
    public boolean update(ItemEntity entity) throws SQLException, ClassNotFoundException {
        return CRUDutil.execute("Update Item set ItemType=?, QtyOnHand=?, ItemPrice=? ,ItemDescription=?, ItemName=? where ItemCode=?",entity.getItemCode(),entity.getItemName(),entity.getItemDescription(),entity.getItemPrice(),entity.getQtyOnHand(),entity.getItemType());
    }

    @Override
    public boolean remove(String id) throws SQLException, ClassNotFoundException {
        return CRUDutil.execute("Delete From Item where ItemCode=?",id);
    }

    @Override
    public ArrayList<ItemEntity> loadItemIds() throws SQLException, ClassNotFoundException {
        ArrayList<ItemEntity> allLoadId = new ArrayList<>();
        ResultSet rst = CRUDutil.execute("SELECT * FROM  Item");
        while (rst.next()){
            ItemEntity itemEntity = new ItemEntity(rst.getString("ItemCode"),rst.getString("ItemName"), rst.getString("ItemDescription"),rst.getDouble("ItemPrice"),rst.getInt("QtyOnHand"),rst.getString("ItemType"));
            allLoadId.add(itemEntity);
        }
        return allLoadId;
    }

    @Override
    public ArrayList<ItemEntity> getItemList() throws SQLException, ClassNotFoundException {
        ArrayList<ItemEntity> allItems = new ArrayList<>();
        ResultSet rst = CRUDutil.execute("select * from Item");
        while (rst.next()){
            ItemEntity itemEntity = new ItemEntity(rst.getString("itemCode"),rst.getString("itemName"),rst.getString("itemDescription"),rst.getInt("itemPrice"),rst.getInt("qtyOnHand"),rst.getString("itemType"));
            allItems.add(itemEntity);
        }
        return allItems;
    }

    @Override
    public ItemEntity getItem(String code) throws SQLException, ClassNotFoundException {
        ResultSet rst = CRUDutil.execute("select * from Item where code = ?", code);
        rst.next();
        return new ItemEntity(rst.getString("itemCode"),rst.getString("itemName"),rst.getString("itemDescription"),rst.getInt("itemPrice"),rst.getInt("qtyOnHand"),rst.getString("itemType"));
    }

    @Override
    public ArrayList<String> loaditemIds() throws SQLException, ClassNotFoundException {
        ArrayList<String> allItemsId = new ArrayList<>();
        ResultSet rst = CRUDutil.execute("SELECT  ItemCode FROM Item");
        while (rst.next()){
            allItemsId.add(rst.getString("itemCode"));
        }
        return allItemsId;
    }

    @Override
    public ArrayList<String> loadItemCodes() throws SQLException, ClassNotFoundException {
        ArrayList<String> allItemsCode = new ArrayList<>();
        ResultSet rst = CRUDutil.execute("SELECT ItemCode FROM Item");
        while (rst.next()){
            allItemsCode.add(rst.getString("itemCode"));
        }
        return allItemsCode;
    }

    @Override
    public ArrayList<String> loadItemTypes() throws SQLException, ClassNotFoundException {
        ArrayList<String> allItemTypes = new ArrayList<>();
        ResultSet rst = CRUDutil.execute("SELECT ItemType FROM Item");
        while (rst.next()){
            allItemTypes.add(rst.getString("itemCode"));
        }
        return allItemTypes;
    }

    @Override
    public ItemEntity searchType(String ItemType) throws SQLException, ClassNotFoundException {
        ResultSet rst = CRUDutil.execute("SELECT * From Item WHERE ItemType = ? ",ItemType);
        while (rst.next()){
            return new ItemEntity(rst.getString("itemCode"),rst.getString("itemName"),rst.getString("itemDescription"),rst.getInt("itemPrice"),rst.getInt("qtyOnHand"),rst.getString("itemType"));
        }
        return null;
    }

    @Override
    public boolean updateQty(String itemCode, int qty) throws SQLException, ClassNotFoundException {
        return CRUDutil.execute("Update Item set QtyOnHand=? where ItemCode=?",itemCode,qty);
    }

    @Override
    public boolean updateQty(ArrayList<OrderDetail> orderDetails) throws SQLException, ClassNotFoundException {
        return CRUDutil.execute("Update Item set QtyOnHand=? where ItemCode=?",orderDetails);
    }
}
