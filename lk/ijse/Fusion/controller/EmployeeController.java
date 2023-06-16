package lk.ijse.Fusion.lk.ijse.Fusion.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.Fusion.lk.ijse.Fusion.Util.CRUDutil;
import lk.ijse.Fusion.lk.ijse.Fusion.bo.BOFactory;
import lk.ijse.Fusion.lk.ijse.Fusion.bo.custom.EmployeeBO;
import lk.ijse.Fusion.lk.ijse.Fusion.model.EmployeeModel;
import lk.ijse.Fusion.lk.ijse.Fusion.dto.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeController {
    @FXML
    public AnchorPane employeeContext;
    @FXML
    public AnchorPane showWindowContext;
    @FXML
    public TextField addressTxt;
    @FXML
    public TextField phonetxt;
    @FXML
    public TextField emailTxt;
    @FXML
    public TextField joindateTxt;
    @FXML
    public TextField dobTxt;
    @FXML
    public TextField Employee_nameTxt;
    @FXML
    public TextField employee_NicTxt;
    @FXML
    public TextField Employe_IdTxt;

    @FXML
    public TextField jobroleTxt;
    @FXML
    public TextField genderTxt;
    public TableView employefullTBL;
    public TableColumn ColemployeeId;
    public TableColumn ColemployeeNic;
    public TableColumn ColName;
    public TableColumn ColAddress;
    public TableColumn ColphoneNumber;
    public TableColumn Colemail;
    public TableColumn Colgender;
    public TableColumn ColDob;
    public TableColumn ColJobrole;
    public TableColumn ColjoinDate;

    EmployeeBO employeeBO = (EmployeeBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.EMPLOYEE);

    @FXML
//    void txtCustomerIdOnAction(ActionEvent event) {
//        String EmployeeId = Employe_IdTxt.getText();
//        try {
////            Employee employee = EmployeeModel.search(EmployeeId);
//            boolean employee = employeeBO.searchEmployee(EmployeeId);
//            if (employee != null) {
//                fillData(employee);
//            }
//        } catch (SQLException | ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//    }





    public void searchOnAction(ActionEvent actionEvent) {
        String EmployeeId  = Employe_IdTxt.getText();
        try {
            //Employee employee = EmployeeModel.search(EmployeeId);
            boolean searchEmployee = employeeBO.searchEmployee(EmployeeId);
            if (searchEmployee) {
                new Alert(Alert.AlertType.CONFIRMATION, "Search Ok!!!!").show();
            }else{
                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private void fillData(Employee employee) {
        Employe_IdTxt.setText(employee.getEmployeeId());
        employee_NicTxt.setText(employee.getEmployeeNIC());
        Employee_nameTxt.setText(employee.getName());
        addressTxt.setText(employee.getAddress());
        emailTxt.setText(employee.getEmail());
        phonetxt.setText(employee.getMobile());
        jobroleTxt.setText(employee.getJobROLE());
        genderTxt.setText(employee.getGender());
        dobTxt.setText(employee.getDOB());
        joindateTxt.setText(employee.getJoinDate());
    }



    public void DeleteOnAction(ActionEvent actionEvent) {
        String EmployeeId = Employe_IdTxt.getText();


        //Employee employee = new Employee(EmployeeId,EmployeeNIC,Name,Address,Email,Mobile,JobROLE,Gender,DOB,JoinDate );
        try {
            boolean deleteEmployee = employeeBO.removeEmployee(EmployeeId);

            if (deleteEmployee) {
                new Alert(Alert.AlertType.CONFIRMATION, "Customer Delete!").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        Employe_IdTxt.clear();employee_NicTxt.clear();Employee_nameTxt.clear();addressTxt.clear();emailTxt.clear();phonetxt.clear();jobroleTxt.clear();genderTxt.clear();dobTxt.clear();joindateTxt.clear();


    }

   public  void UpdateOnAction(ActionEvent actionEvent) {
        String EmployeeId = Employe_IdTxt.getText();
        String  EmployeeNIC = employee_NicTxt.getText();
        String Name = Employee_nameTxt.getText();
        String Address = addressTxt.getText();
        String  Email = emailTxt.getText();
        String Mobile = phonetxt.getText();
        String JobROLE =  jobroleTxt.getText();
        String Gender=genderTxt.getText();
        String DOB = dobTxt.getText();
        String JoinDate = joindateTxt.getText();

        //Employee employee = new Employee(EmployeeId,EmployeeNIC,Name,Address,Email,Mobile,JobROLE,Gender,DOB,JoinDate );
        try {
            boolean updateEmployee = employeeBO.updateEmployee(new Employee(EmployeeId,EmployeeNIC,Name,Address,Email,Mobile,JobROLE,Gender,DOB,JoinDate));

            if (updateEmployee) {
                new Alert(Alert.AlertType.CONFIRMATION, "Employee Update!").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
       Employe_IdTxt.clear();employee_NicTxt.clear();Employee_nameTxt.clear();addressTxt.clear();emailTxt.clear();phonetxt.clear();jobroleTxt.clear();genderTxt.clear();dobTxt.clear();joindateTxt.clear();


   }

@FXML
   void AddOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String EmployeeId = Employe_IdTxt.getText();
        String  EmployeeNIC = employee_NicTxt.getText();
        String Name = Employee_nameTxt.getText();
        String Address = addressTxt.getText();
        String  Email = emailTxt.getText();
        String Mobile = phonetxt.getText();
        String JobROLE =  jobroleTxt.getText();
        String Gender=genderTxt.getText();
        String DOB = dobTxt.getText();
        String JoinDate = joindateTxt.getText();

        //Employee employee = new Employee(EmployeeId,EmployeeNIC,Name,Address,Email,Mobile,JobROLE,Gender,DOB,JoinDate);
        boolean addEmployee = employeeBO.addEmployee(new Employee(EmployeeId,EmployeeNIC,Name,Address,Email,Mobile,JobROLE,Gender,DOB,JoinDate));

        if (addEmployee) {
            new Alert(Alert.AlertType.CONFIRMATION, "Employe Added!").show();
        } else {
            new Alert(Alert.AlertType.WARNING, "Something happened!").show();
        }
    Employe_IdTxt.clear();employee_NicTxt.clear();Employee_nameTxt.clear();addressTxt.clear();emailTxt.clear();phonetxt.clear();jobroleTxt.clear();genderTxt.clear();dobTxt.clear();joindateTxt.clear();

    }

    public void initialize() {
        ColemployeeId.setCellValueFactory(new PropertyValueFactory("EmployeeId"));
        ColemployeeNic.setCellValueFactory(new PropertyValueFactory("EmployeeNIC"));
        ColName.setCellValueFactory(new PropertyValueFactory("Name"));
        ColAddress.setCellValueFactory(new PropertyValueFactory("Address"));
        Colemail.setCellValueFactory(new PropertyValueFactory("Email"));
        ColphoneNumber.setCellValueFactory(new PropertyValueFactory("Mobile"));
        ColJobrole.setCellValueFactory(new PropertyValueFactory("JobROLE"));
        ColDob.setCellValueFactory(new PropertyValueFactory("DOB"));
        ColjoinDate.setCellValueFactory(new PropertyValueFactory("JoinDate"));
        Colgender.setCellValueFactory(new PropertyValueFactory("Gender"));

        try {
            loadAllEmployee();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();

        }
    }



    private void loadAllEmployee() throws SQLException, ClassNotFoundException {
//        ResultSet resultSet = CRUDutil.execute("SELECT * FROM  fusiontech.Employee");
//        ObservableList<Employee> observableList = FXCollections.observableArrayList();
//        while(resultSet.next()){
//            observableList.add(
//                    new Employee(
//                            resultSet.getString("EmployeeId"),
//                            resultSet.getString("EmployeeNIC"),
//                            resultSet.getString("Name"),
//                            resultSet.getString("Address"),
//                            resultSet.getString("Email"),
//                            resultSet.getString("Mobile"),
//                            resultSet.getString("JobROLE"),
//                            resultSet.getString("DOB"),
//                            resultSet.getString("JoinDate"),
//                            resultSet.getString("Gender")
//                    )
//            );
//        }
//        employefullTBL.setItems(observableList);
        ArrayList<Employee> allEmployee = employeeBO.loadEmployeeIds();
        for (Employee e:allEmployee) {
            employefullTBL.getItems().add(new Employee(e.getEmployeeId(),e.getEmployeeNIC(),e.getName(),e.getAddress(),e.getEmail(),e.getMobile(),e.getJobROLE(),e.getDOB(),e.getJoinDate(),e.getGender()));
        }
    }


    public void ReloadOnAction(ActionEvent actionEvent) {
        initialize();
    }
}
