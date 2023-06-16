package lk.ijse.Fusion.lk.ijse.Fusion.entity;


public class AttendanceEntity {
    private String AttendID;
    private int AttendDate;
    private String InTime;
    private String OutTime;
    private String stetus;

    public AttendanceEntity() {
    }

    public AttendanceEntity(String attendID, int attendDate, String inTime, String outTime, String stetus) {
        AttendID = attendID;
        AttendDate = attendDate;
        InTime = inTime;
        OutTime = outTime;
        this.stetus = stetus;
    }

    public String getAttendID() {
        return AttendID;
    }

    public void setAttendID(String attendID) {
        AttendID = attendID;
    }

    public int getAttendDate() {
        return AttendDate;
    }

    public void setAttendDate(int attendDate) {
        AttendDate = attendDate;
    }

    public String getInTime() {
        return InTime;
    }

    public void setInTime(String inTime) {
        InTime = inTime;
    }

    public String getOutTime() {
        return OutTime;
    }

    public void setOutTime(String outTime) {
        OutTime = outTime;
    }

    public String getStetus() {
        return stetus;
    }

    public void setStetus(String stetus) {
        this.stetus = stetus;
    }

    @Override
    public String toString() {
        return "AttendanceEntity{" +
                "AttendID='" + AttendID + '\'' +
                ", AttendDate=" + AttendDate +
                ", InTime='" + InTime + '\'' +
                ", OutTime='" + OutTime + '\'' +
                ", stetus='" + stetus + '\'' +
                '}';
    }
}
