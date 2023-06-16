package lk.ijse.Fusion.lk.ijse.Fusion.dao.custom;


import lk.ijse.Fusion.lk.ijse.Fusion.dao.CrudDAO;
import lk.ijse.Fusion.lk.ijse.Fusion.entity.AttendanceEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public interface AttendanceDAO extends CrudDAO<AttendanceEntity> {
    public ArrayList<AttendanceEntity> getAllAttendance() throws SQLException, ClassNotFoundException;

}
