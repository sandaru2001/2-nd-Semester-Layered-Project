package lk.ijse.Fusion.lk.ijse.Fusion.bo.custom.impl;

import lk.ijse.Fusion.lk.ijse.Fusion.bo.custom.SalaryBO;
import lk.ijse.Fusion.lk.ijse.Fusion.dao.DAOFactory;
import lk.ijse.Fusion.lk.ijse.Fusion.dao.custom.SalaryDAO;
import lk.ijse.Fusion.lk.ijse.Fusion.dto.Salary;
import lk.ijse.Fusion.lk.ijse.Fusion.entity.SalaryEntity;

import java.sql.SQLException;

public class SalaryBOImpl implements SalaryBO {

    SalaryDAO salaryDAO = (SalaryDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.SALARY);

    @Override
    public boolean addSalary(Salary dto) throws SQLException, ClassNotFoundException {
        return salaryDAO.add(new SalaryEntity(dto.getSalaryID(), dto.getSalaryMethod(), dto.getSalaryAmount(), dto.getDetails(), dto.getEmployeeID()));
    }

    @Override
    public boolean updateSalary(Salary dto) throws SQLException, ClassNotFoundException {
        return salaryDAO.update(new SalaryEntity(dto.getSalaryID(), dto.getSalaryMethod(), dto.getSalaryAmount(), dto.getDetails(), dto.getEmployeeID()));
    }

    @Override
    public boolean removeSalary(String id) throws SQLException, ClassNotFoundException {
        return salaryDAO.remove(id);
    }
}
