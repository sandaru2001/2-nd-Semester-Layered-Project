package lk.ijse.Fusion.lk.ijse.Fusion.dao;

import lk.ijse.Fusion.lk.ijse.Fusion.dto.Attendence;

import java.sql.SQLException;

public interface CrudDAO<T> extends SuperDAO{
    public boolean add(T entity) throws SQLException, ClassNotFoundException;

    public boolean search(String id) throws SQLException, ClassNotFoundException;

    public boolean update(T entity) throws SQLException, ClassNotFoundException;

    public boolean remove(String id) throws SQLException, ClassNotFoundException;
}
