package lk.ijse.Fusion.lk.ijse.Fusion.dao.custom;

import lk.ijse.Fusion.lk.ijse.Fusion.dao.CrudDAO;
import lk.ijse.Fusion.lk.ijse.Fusion.entity.EmployeeEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public interface EmployeeDAO extends CrudDAO<EmployeeEntity> {
    public ArrayList<EmployeeEntity> loadEmployeeIds() throws SQLException, ClassNotFoundException;

}
