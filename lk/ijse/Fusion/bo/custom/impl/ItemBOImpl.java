package lk.ijse.Fusion.lk.ijse.Fusion.bo.custom.impl;

import lk.ijse.Fusion.lk.ijse.Fusion.bo.custom.ItemBO;
import lk.ijse.Fusion.lk.ijse.Fusion.dao.DAOFactory;
import lk.ijse.Fusion.lk.ijse.Fusion.dao.custom.ItemDAO;
import lk.ijse.Fusion.lk.ijse.Fusion.dto.Item;
import lk.ijse.Fusion.lk.ijse.Fusion.entity.ItemEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBOImpl implements ItemBO {

    ItemDAO itemDAO = (ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ITEM);

    @Override
    public ArrayList<Item> loadItemIds() throws SQLException, ClassNotFoundException {
        ArrayList<Item> allIds = new ArrayList<>();
        ArrayList<ItemEntity> all = itemDAO.loadItemIds();
        for (ItemEntity i:all) {
            allIds.add(new Item(i.getItemCode(),i.getItemName(),i.getItemDescription(),i.getItemPrice(),i.getQtyOnHand(),i.getItemType()));
        }
        return allIds;
    }

    @Override
    public boolean addItem(Item dto) throws SQLException, ClassNotFoundException {
        return itemDAO.add(new ItemEntity(dto.getItemCode(), dto.getItemName(), dto.getItemDescription(),dto.getItemPrice(),dto.getQtyOnHand(),dto.getItemType()));
    }

    @Override
    public boolean searchItem(String id) throws SQLException, ClassNotFoundException {
        return itemDAO.search(id);
    }

    @Override
    public boolean updateItem(Item dto) throws SQLException, ClassNotFoundException {
        return itemDAO.update(new ItemEntity(dto.getItemCode(), dto.getItemName(), dto.getItemDescription(),dto.getItemPrice(),dto.getQtyOnHand(),dto.getItemType()));
    }

    @Override
    public boolean removeItem(String id) throws SQLException, ClassNotFoundException {
        return itemDAO.remove(id);
    }
}
