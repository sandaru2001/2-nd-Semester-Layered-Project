package lk.ijse.Fusion.lk.ijse.Fusion.bo.custom;

import lk.ijse.Fusion.lk.ijse.Fusion.bo.SuperBO;
import lk.ijse.Fusion.lk.ijse.Fusion.dto.Suppliers;

import java.sql.SQLException;

public interface SupplierBO extends SuperBO {
    public boolean addSuppliers(Suppliers dto) throws SQLException, ClassNotFoundException;

    public boolean searchSuppliers(String id) throws SQLException, ClassNotFoundException;

    public boolean updateSuppliers(Suppliers dto) throws SQLException, ClassNotFoundException;

    public boolean removeSuppliers(String id) throws SQLException, ClassNotFoundException;
}
