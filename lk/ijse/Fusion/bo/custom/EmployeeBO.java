package lk.ijse.Fusion.lk.ijse.Fusion.bo.custom;

import lk.ijse.Fusion.lk.ijse.Fusion.bo.SuperBO;
import lk.ijse.Fusion.lk.ijse.Fusion.dto.Employee;

import java.sql.SQLException;
import java.util.ArrayList;

public interface EmployeeBO extends SuperBO {
    public ArrayList<Employee> loadEmployeeIds() throws SQLException, ClassNotFoundException;

    public boolean addEmployee(Employee entity) throws SQLException, ClassNotFoundException;

    public boolean searchEmployee(String id) throws SQLException, ClassNotFoundException;

    public boolean updateEmployee(Employee entity) throws SQLException, ClassNotFoundException;

    public boolean removeEmployee(String id) throws SQLException, ClassNotFoundException;
}
