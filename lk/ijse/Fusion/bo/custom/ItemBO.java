package lk.ijse.Fusion.lk.ijse.Fusion.bo.custom;

import lk.ijse.Fusion.lk.ijse.Fusion.bo.SuperBO;
import lk.ijse.Fusion.lk.ijse.Fusion.dto.Employee;
import lk.ijse.Fusion.lk.ijse.Fusion.dto.Item;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemBO extends SuperBO {
    public ArrayList<Item> loadItemIds() throws SQLException, ClassNotFoundException;

    public boolean addItem(Item dto) throws SQLException, ClassNotFoundException;

    public boolean searchItem(String id) throws SQLException, ClassNotFoundException;

    public boolean updateItem(Item dto) throws SQLException, ClassNotFoundException;

    public boolean removeItem(String id) throws SQLException, ClassNotFoundException;
}
