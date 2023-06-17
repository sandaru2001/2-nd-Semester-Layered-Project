package lk.ijse.Fusion.lk.ijse.Fusion.dao.custom.impl;

import lk.ijse.Fusion.lk.ijse.Fusion.Util.CRUDutil;
import lk.ijse.Fusion.lk.ijse.Fusion.dao.custom.SalaryDAO;
import lk.ijse.Fusion.lk.ijse.Fusion.entity.SalaryEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SalaryDAOImpl implements SalaryDAO {
    @Override
    public boolean add(SalaryEntity entity) throws SQLException, ClassNotFoundException {
        return CRUDutil.execute("INSERT INTO Salary VALUES (?, ?, ?, ?, ?)",entity.getSalaryID(),entity.getSalaryMethod(),entity.getSalaryAmount(),entity.getDetails(),entity.getEmployeeID());
    }

    @Override
    public boolean search(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(SalaryEntity entity) throws SQLException, ClassNotFoundException {
        ResultSet rst = CRUDutil.execute("Update Salary set Details=?,SalaryMethod=?, SalaryAmount=?, EmployeeID=?   where SalaryID=?",entity.getDetails(),entity.getSalaryMethod(),entity.getSalaryAmount(),entity.getEmployeeID(),entity.getSalaryID());
        return rst.next();
    }

    @Override
    public boolean remove(String id) throws SQLException, ClassNotFoundException {
        return CRUDutil.execute("Delete From Salary where SalaryID= ?",id);
    }
}
