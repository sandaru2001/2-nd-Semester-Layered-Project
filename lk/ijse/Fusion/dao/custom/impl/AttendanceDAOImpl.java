package lk.ijse.Fusion.lk.ijse.Fusion.dao.custom.impl;

import lk.ijse.Fusion.lk.ijse.Fusion.Util.CRUDutil;
import lk.ijse.Fusion.lk.ijse.Fusion.dao.custom.AttendanceDAO;
import lk.ijse.Fusion.lk.ijse.Fusion.dto.Attendence;
import lk.ijse.Fusion.lk.ijse.Fusion.entity.AttendanceEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AttendanceDAOImpl implements AttendanceDAO {
    @Override
    public boolean add(AttendanceEntity entity) throws SQLException, ClassNotFoundException {
        return CRUDutil.execute("INSERT INTO fusiontech.attendence VALUES (?, ?, ?, ?, ?)",entity.getAttendID(),entity.getAttendDate(),entity.getInTime(),entity.getOutTime(),entity.getStetus());
    }

    @Override
    public boolean search(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = CRUDutil.execute("SELECT * From fusiontech.attendence   WHERE  AttendID = ?",id);
        return rst.next();

    }


    @Override
    public boolean update(AttendanceEntity entity) throws SQLException, ClassNotFoundException {
        return CRUDutil.execute("Update attendence set stetus=?,OutTime=?, InTime=?, AttendDate=?   where AttendID=?",entity.getStetus(),entity.getOutTime(),entity.getInTime(),entity.getAttendDate(),entity.getAttendID());
    }

    @Override
    public boolean remove(String id) throws SQLException, ClassNotFoundException {
        return CRUDutil.execute("Delete From attendence where AttendID=?",id);
    }

    @Override
    public ArrayList<AttendanceEntity> getAllAttendance() throws SQLException, ClassNotFoundException {
        ArrayList<AttendanceEntity> allAttendance = new ArrayList<>();
        ResultSet rst = CRUDutil.execute("SELECT * FROM fusiontech.attendence");
        while (rst.next()){
            AttendanceEntity attendanceEntity = new AttendanceEntity(rst.getString("AttendID"),rst.getInt("AttendDate"),rst.getString("InTime"),rst.getString("OutTime"),rst.getString("stetus"));
            allAttendance.add(attendanceEntity);
        }
        return allAttendance;
    }
}
