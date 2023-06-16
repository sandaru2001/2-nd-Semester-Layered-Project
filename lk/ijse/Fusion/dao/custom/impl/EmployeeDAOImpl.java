package lk.ijse.Fusion.lk.ijse.Fusion.dao.custom.impl;

import lk.ijse.Fusion.lk.ijse.Fusion.Util.CRUDutil;
import lk.ijse.Fusion.lk.ijse.Fusion.dao.custom.EmployeeDAO;
import lk.ijse.Fusion.lk.ijse.Fusion.entity.EmployeeEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public boolean add(EmployeeEntity entity) throws SQLException, ClassNotFoundException {
        return CRUDutil.execute("INSERT INTO Employee VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",entity.getEmployeeId(),entity.getEmployeeNIC(),entity.getName(),entity.getAddress(),entity.getEmail(),entity.getMobile(),entity.getJobROLE(),entity.getDOB(),entity.getJoinDate(),entity.getGender());
    }

    @Override
    public boolean search(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = CRUDutil.execute("SELECT * From Employee WHERE employeeId = ?",id);
        return rst.next();
    }

    @Override
    public boolean update(EmployeeEntity entity) throws SQLException, ClassNotFoundException {
        return CRUDutil.execute("Update Employee set Gender=?, JoinDate=?, DOB=? ,JobROLE=?, Mobile=? ,Email=?,Address=?, Name=?, EmployeeNIC=? where EmployeeId=?",entity.getGender(),entity.getJoinDate(),entity.getDOB(),entity.getJobROLE(),entity.getMobile(),entity.getEmail(),entity.getAddress(),entity.getName(),entity.getEmployeeNIC(),entity.getEmployeeId());
    }

    @Override
    public boolean remove(String id) throws SQLException, ClassNotFoundException {
        return CRUDutil.execute("Delete From Employee where EmployeeId = ?",id);
    }

    @Override
    public ArrayList<EmployeeEntity> loadEmployeeIds() throws SQLException, ClassNotFoundException {
        ArrayList<EmployeeEntity> allEmployee = new ArrayList<>();
        ResultSet rst = CRUDutil.execute("SELECT * FROM  fusiontech.Employee");
        while (rst.next()){
            EmployeeEntity employeeEntity = new EmployeeEntity(rst.getString("EmployeeId"),rst.getString("EmployeeNIC"),rst.getString("Name"),rst.getString("Address"),rst.getString("Email"),rst.getString("Mobile"),rst.getString("JobROLE"),rst.getString("DOB"),rst.getString("JoinDate"),rst.getString("Gender"));
            allEmployee.add(employeeEntity);
        }
        return allEmployee;
    }
}
