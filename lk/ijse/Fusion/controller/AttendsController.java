package lk.ijse.Fusion.lk.ijse.Fusion.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.Fusion.lk.ijse.Fusion.Util.CRUDutil;
import lk.ijse.Fusion.lk.ijse.Fusion.bo.BOFactory;
import lk.ijse.Fusion.lk.ijse.Fusion.bo.custom.AttendanceBO;
import lk.ijse.Fusion.lk.ijse.Fusion.dao.CrudDAO;
import lk.ijse.Fusion.lk.ijse.Fusion.dao.DAOFactory;
import lk.ijse.Fusion.lk.ijse.Fusion.dao.custom.impl.AttendanceDAOImpl;
import lk.ijse.Fusion.lk.ijse.Fusion.model.AttendModel;
import lk.ijse.Fusion.lk.ijse.Fusion.dto.Attendence;
import lk.ijse.Fusion.lk.ijse.Fusion.tm.AttendanceTM;

import java.sql.ResultSet;
import java.sql.SQLException;



import java.util.ArrayList;

public class AttendsController {


    public TextField inTimeTxt;
    public TextField outTimeTxt;
    public TextField dateTxt;
    public TextField employeestetusTxt;

    public TableView TblfullAttends;
    public TableColumn ColattendId;
    public TableColumn Coldate;
    public TableColumn Col_inTime;
    public TableColumn Col_outTime;
    public TableColumn Colstetus;
    public TextField attendsId_Txt;

    AttendanceBO attendanceBO = (AttendanceBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.ATTENDANCE);

    public void initialize() {
        ColattendId.setCellValueFactory(new PropertyValueFactory("AttendID"));
        Coldate.setCellValueFactory(new PropertyValueFactory("AttendDate"));
        Col_inTime.setCellValueFactory(new PropertyValueFactory("InTime"));
        Col_outTime.setCellValueFactory(new PropertyValueFactory("OutTime"));
        Colstetus.setCellValueFactory(new PropertyValueFactory("stetus"));
        try {
            loadAllAttends();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();

        }
    }


    private void loadAllAttends() throws SQLException, ClassNotFoundException {
//        ResultSet resultSet = CRUDutil.execute("SELECT * FROM fusiontech.attendence");
//        ObservableList<Attendence> observableList = FXCollections.observableArrayList();
//        while(resultSet.next()){
//            observableList.add(
//                    new Attendence(
//                            resultSet.getString("AttendID"),
//                            resultSet.getInt("AttendDate"),
//                            resultSet.getString("InTime"),
//                            resultSet.getString("OutTime"),
//                            resultSet.getString("stetus")
//                    )
//            );
//        }
//        TblfullAttends.setItems(observableList);
        TblfullAttends.getItems().clear();
        try {
            ArrayList<Attendence> allAttendence = attendanceBO.getallAttendance();

            for (Attendence a:allAttendence) {
                TblfullAttends.getItems().add(new AttendanceTM(a.getAttendID(),a.getAttendDate(),a.getInTime(),a.getOutTime(),a.getStetus()));
            }
        }catch (SQLException e){
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }catch (ClassNotFoundException e){
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }


    @FXML
     public void AddOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String  AttendID  =  attendsId_Txt.getText();
        int  AttendDate =Integer.parseInt(dateTxt.getText());
        String InTime = inTimeTxt.getText();
        String OutTime = outTimeTxt.getText();
        String  stetus = employeestetusTxt.getText();
//
        attendanceBO.addAttendance(new Attendence(AttendID,AttendDate,InTime,OutTime,stetus));
//        Attendence attendence = new Attendence(AttendID,AttendDate,InTime,OutTime,stetus);
//
        //boolean isAdded = AttendModel.addAttends(attendence);
        if (attendanceBO!=null) {
            new Alert(Alert.AlertType.CONFIRMATION, "Attends Added!").show();
        } else {
            new Alert(Alert.AlertType.WARNING, "Something happened!").show();
        }

        TblfullAttends.getItems().add(new AttendanceTM(AttendID,AttendDate,InTime,OutTime,stetus));
        //        attendsId_Txt.clear();dateTxt.clear();inTimeTxt.clear();outTimeTxt.clear();employeestetusTxt.clear();
    }


    private void fillData(Attendence attendence) {
        attendsId_Txt.setText(attendence.getAttendID());
        dateTxt.setText(String.valueOf(attendence.getAttendDate()));
        inTimeTxt.setText(attendence.getInTime());
        outTimeTxt.setText(attendence.getOutTime());
        employeestetusTxt.setText(attendence.getStetus());
    }

    public void SearchOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String AttendID =  attendsId_Txt.getText();
        attendanceBO.searchAttendance(AttendID);
        try {
            boolean attendance = attendanceBO.searchAttendance(AttendID);
            if (attendance) {
                new Alert(Alert.AlertType.CONFIRMATION, "Search Ok!!!!").show();
            }else{
                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void UpdateOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String  AttendID  =  attendsId_Txt.getText();
        int  AttendDate = Integer.parseInt(dateTxt.getText());
        String InTime = inTimeTxt.getText();
        String OutTime = outTimeTxt.getText();
        String  stetus = employeestetusTxt.getText();

        //Attendence attendence = new Attendence(AttendID,AttendDate,InTime,OutTime,stetus);
        attendanceBO.updateAttendance(new Attendence(AttendID,AttendDate,InTime,OutTime,stetus));
        attendanceBO.addAttendance(new Attendence(AttendID,AttendDate,InTime,OutTime,stetus));
        try {
            //boolean isUpdate = AttendModel.update(attendence);
            boolean updateAttendance = attendanceBO.updateAttendance(new Attendence(AttendID,AttendDate,InTime,OutTime,stetus));
            if (updateAttendance) {
                new Alert(Alert.AlertType.CONFIRMATION, "Attends Update!").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            //boolean isAdded = AttendModel.addAttends(attendence);
            boolean addAttendance = attendanceBO.addAttendance(new Attendence(AttendID,AttendDate,InTime,OutTime,stetus));
            if (addAttendance) {
                new Alert(Alert.AlertType.CONFIRMATION, "Attends Added!").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        attendsId_Txt.clear();dateTxt.clear();inTimeTxt.clear();outTimeTxt.clear();employeestetusTxt.clear();

    }

    public void DeleteOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String  AttendID  =  attendsId_Txt.getText();
        int  AttendDate = Integer.parseInt( dateTxt.getText());
        String InTime =  inTimeTxt.getText();
        String OutTime = outTimeTxt.getText();
        String  stetus = employeestetusTxt.getText();

        //Attendence attendence = new Attendence(AttendID,AttendDate,InTime,OutTime,stetus);
        attendanceBO.removeAttendance(AttendID);
        attendanceBO.addAttendance(new Attendence(AttendID,AttendDate,InTime,OutTime,stetus));
        try {
            //boolean isDeleted = AttendModel.remove(attendsId_Txt.getText());
            boolean deleteAttendance = attendanceBO.removeAttendance(AttendID);
            if (deleteAttendance) {
                new Alert(Alert.AlertType.CONFIRMATION, "Attends Delete!").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            //boolean isAdded = AttendModel.addAttends(attendence);
            boolean addAttendance = attendanceBO.addAttendance(new Attendence(AttendID,AttendDate,InTime,OutTime,stetus));
            if (addAttendance) {
                new Alert(Alert.AlertType.CONFIRMATION, "Attends Added!").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        attendsId_Txt.clear();dateTxt.clear();inTimeTxt.clear();outTimeTxt.clear();employeestetusTxt.clear();

    }

    public void ReloadOnAction(ActionEvent actionEvent) {
        initialize();
    }



}
