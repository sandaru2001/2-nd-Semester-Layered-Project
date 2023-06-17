package lk.ijse.Fusion.lk.ijse.Fusion.bo.custom;

import lk.ijse.Fusion.lk.ijse.Fusion.bo.SuperBO;
import lk.ijse.Fusion.lk.ijse.Fusion.dto.Salary;

import java.sql.SQLException;

public interface SalaryBO extends SuperBO {
    public boolean addSalary(Salary dto) throws SQLException, ClassNotFoundException;

    public boolean updateSalary(Salary dto) throws SQLException, ClassNotFoundException;

    public boolean removeSalary(String id) throws SQLException, ClassNotFoundException;
}
