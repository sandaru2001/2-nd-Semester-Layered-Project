package lk.ijse.Fusion.lk.ijse.Fusion.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import lk.ijse.Fusion.lk.ijse.Fusion.bo.BOFactory;
import lk.ijse.Fusion.lk.ijse.Fusion.bo.custom.SalaryBO;
import lk.ijse.Fusion.lk.ijse.Fusion.model.SalaryModel;
import lk.ijse.Fusion.lk.ijse.Fusion.dto.Salary;

import java.sql.SQLException;

public class SalaryFormController {
    public TextField amountTxt;
    public TextField employeeIdTxt;
    public TextField SalaryIdtxt;
    public TextField salaryMethodTxt;
    public TextField txtDetail;

    SalaryBO salaryBO = (SalaryBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.SALARY);


    public void deleteOnAction(ActionEvent actionEvent) {
        String  SalaryID  =  SalaryIdtxt.getText();
        String  EmployeeID =employeeIdTxt.getText();
        double SalaryAmount = Double.parseDouble(amountTxt.getText());
        String SalaryMethod = salaryMethodTxt.getText();
        String  Details = txtDetail.getText();

        //Salary salary = new Salary(SalaryID,EmployeeID,SalaryAmount,SalaryMethod,Details);
        try {
            boolean deleteSalary = salaryBO.removeSalary(SalaryID);

            if (deleteSalary) {
                new Alert(Alert.AlertType.CONFIRMATION, "Salary Delete!").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateOnAction(ActionEvent actionEvent) {
        String  SalaryID  =  SalaryIdtxt.getText();
        String  EmployeeID =employeeIdTxt.getText();
        double SalaryAmount = Double.parseDouble(amountTxt.getText());
        String SalaryMethod = salaryMethodTxt.getText();
        String  Details = txtDetail.getText();

        //Salary salary = new Salary(SalaryID,EmployeeID,SalaryAmount,SalaryMethod,Details);
        try {
            boolean updateSalary = salaryBO.updateSalary(new Salary(SalaryID,SalaryMethod,SalaryAmount,Details,EmployeeID));

            if (updateSalary) {
                new Alert(Alert.AlertType.CONFIRMATION, "Salary Update!").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void addOnAction(ActionEvent actionEvent) {
        String  SalaryID  =  SalaryIdtxt.getText();
        String  EmployeeID =employeeIdTxt.getText();
        double SalaryAmount = Double.parseDouble(amountTxt.getText());
        String SalaryMethod = salaryMethodTxt.getText();
        String  Details = txtDetail.getText();


        //Salary salary = new Salary(SalaryID,EmployeeID,SalaryAmount,SalaryMethod,Details);
        try {
            boolean addSalary = salaryBO.addSalary(new Salary(SalaryID,EmployeeID,SalaryAmount,SalaryMethod,Details));

            if (addSalary) {
                new Alert(Alert.AlertType.CONFIRMATION, "Salary Added!").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
