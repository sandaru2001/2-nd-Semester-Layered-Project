package lk.ijse.Fusion.lk.ijse.Fusion.bo.custom.impl;

import lk.ijse.Fusion.lk.ijse.Fusion.bo.custom.AttendanceBO;
import lk.ijse.Fusion.lk.ijse.Fusion.dao.DAOFactory;
import lk.ijse.Fusion.lk.ijse.Fusion.dao.custom.AttendanceDAO;
import lk.ijse.Fusion.lk.ijse.Fusion.dto.Attendence;
import lk.ijse.Fusion.lk.ijse.Fusion.entity.AttendanceEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public class AttendanceBOImpl implements AttendanceBO {

    AttendanceDAO attendanceDAO = (AttendanceDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ATTENDANCE);

    @Override
    public ArrayList<Attendence> getallAttendance() throws SQLException, ClassNotFoundException {
        ArrayList<Attendence> allAttendance = new ArrayList<>();
        ArrayList<AttendanceEntity> all = attendanceDAO.getAllAttendance();
        for (AttendanceEntity a:all) {
            allAttendance.add(new Attendence(a.getAttendID(),a.getAttendDate(),a.getInTime(),a.getOutTime()));
        }
        return allAttendance;
    }

    @Override
    public boolean addAttendance(Attendence dto) throws SQLException, ClassNotFoundException {
        return attendanceDAO.add(new AttendanceEntity(dto.getAttendID(),dto.getAttendDate(),dto.getInTime(),dto.getOutTime(),dto.getStetus()));
    }

    @Override
    public boolean searchAttendance(String id) throws SQLException, ClassNotFoundException {
        return attendanceDAO.search(id);
    }

    @Override
    public boolean updateAttendance(Attendence dto) throws SQLException, ClassNotFoundException {
        return attendanceDAO.update(new AttendanceEntity(dto.getAttendID(),dto.getAttendDate(),dto.getInTime(),dto.getOutTime(),dto.getStetus()));
    }

    @Override
    public boolean removeAttendance(String id) throws SQLException, ClassNotFoundException {
        return attendanceDAO.remove(id);
    }
}
