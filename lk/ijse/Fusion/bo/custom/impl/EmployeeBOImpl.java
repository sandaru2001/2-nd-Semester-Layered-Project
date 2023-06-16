package lk.ijse.Fusion.lk.ijse.Fusion.bo.custom.impl;

import lk.ijse.Fusion.lk.ijse.Fusion.bo.custom.EmployeeBO;
import lk.ijse.Fusion.lk.ijse.Fusion.dao.DAOFactory;
import lk.ijse.Fusion.lk.ijse.Fusion.dao.custom.EmployeeDAO;
import lk.ijse.Fusion.lk.ijse.Fusion.dto.Employee;
import lk.ijse.Fusion.lk.ijse.Fusion.entity.EmployeeEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeBOImpl implements EmployeeBO {

    EmployeeDAO employeeDAO = (EmployeeDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.EMPLOYEE);

    @Override
    public ArrayList<Employee> loadEmployeeIds() throws SQLException, ClassNotFoundException {
        ArrayList<Employee> allEmployee = new ArrayList<>();
        ArrayList<EmployeeEntity> all = employeeDAO.loadEmployeeIds();
        for (EmployeeEntity e:all) {
            allEmployee.add(new Employee(e.getEmployeeId(),e.getEmployeeNIC(),e.getName(),e.getAddress(),e.getEmail(),e.getMobile(),e.getJobROLE(),e.getDOB(),e.getJoinDate(),e.getGender()));
        }
        return allEmployee;
    }

    @Override
    public boolean addEmployee(Employee entity) throws SQLException, ClassNotFoundException {
        return employeeDAO.add(new EmployeeEntity(entity.getEmployeeId(),entity.getEmployeeNIC(),entity.getName(),entity.getAddress(),entity.getEmail(),entity.getMobile(),entity.getJobROLE(),entity.getDOB(),entity.getJoinDate(),entity.getGender()));
    }

    @Override
    public boolean searchEmployee(String id) throws SQLException, ClassNotFoundException {
        return employeeDAO.search(id);
    }

    @Override
    public boolean updateEmployee(Employee entity) throws SQLException, ClassNotFoundException {
        return employeeDAO.update(new EmployeeEntity(entity.getEmployeeId(),entity.getEmployeeNIC(),entity.getName(),entity.getAddress(),entity.getEmail(),entity.getMobile(),entity.getJobROLE(),entity.getDOB(),entity.getJoinDate(),entity.getGender()));
    }

    @Override
    public boolean removeEmployee(String id) throws SQLException, ClassNotFoundException {
        return employeeDAO.remove(id);
    }
}
