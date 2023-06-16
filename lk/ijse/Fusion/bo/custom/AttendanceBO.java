package lk.ijse.Fusion.lk.ijse.Fusion.bo.custom;

import lk.ijse.Fusion.lk.ijse.Fusion.bo.SuperBO;
import lk.ijse.Fusion.lk.ijse.Fusion.dto.Attendence;

import java.sql.SQLException;
import java.util.ArrayList;

public interface AttendanceBO extends SuperBO {
    public ArrayList<Attendence> getallAttendance() throws SQLException, ClassNotFoundException;

    public boolean addAttendance(Attendence dto) throws SQLException, ClassNotFoundException;

    public boolean searchAttendance(String id) throws SQLException, ClassNotFoundException;

    public boolean updateAttendance(Attendence dto) throws SQLException, ClassNotFoundException;

    public boolean removeAttendance(String id) throws SQLException, ClassNotFoundException;
}
