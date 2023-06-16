package lk.ijse.Fusion.lk.ijse.Fusion.entity;

public class DeliveryEntity {
    private String DeliveryID;
    private String DriverNic;
    private String DriverName;
    private String DeliveryDate;
    private String ArriavalTime;
    private String DeliveryFee;
    private String Stetus;
    private String OrderID;

    public DeliveryEntity() {
    }

    public DeliveryEntity(String deliveryID, String driverNic, String driverName, String deliveryDate, String arriavalTime, String deliveryFee, String stetus, String orderID) {
        DeliveryID = deliveryID;
        DriverNic = driverNic;
        DriverName = driverName;
        DeliveryDate = deliveryDate;
        ArriavalTime = arriavalTime;
        DeliveryFee = deliveryFee;
        Stetus = stetus;
        OrderID = orderID;
    }

    public String getDeliveryID() {
        return DeliveryID;
    }

    public void setDeliveryID(String deliveryID) {
        DeliveryID = deliveryID;
    }

    public String getDriverNic() {
        return DriverNic;
    }

    public void setDriverNic(String driverNic) {
        DriverNic = driverNic;
    }

    public String getDriverName() {
        return DriverName;
    }

    public void setDriverName(String driverName) {
        DriverName = driverName;
    }

    public String getDeliveryDate() {
        return DeliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        DeliveryDate = deliveryDate;
    }

    public String getArriavalTime() {
        return ArriavalTime;
    }

    public void setArriavalTime(String arriavalTime) {
        ArriavalTime = arriavalTime;
    }

    public String getDeliveryFee() {
        return DeliveryFee;
    }

    public void setDeliveryFee(String deliveryFee) {
        DeliveryFee = deliveryFee;
    }

    public String getStetus() {
        return Stetus;
    }

    public void setStetus(String stetus) {
        Stetus = stetus;
    }

    public String getOrderID() {
        return OrderID;
    }

    public void setOrderID(String orderID) {
        OrderID = orderID;
    }

    @Override
    public String toString() {
        return "DeliveryEntity{" +
                "DeliveryID='" + DeliveryID + '\'' +
                ", DriverNic='" + DriverNic + '\'' +
                ", DriverName='" + DriverName + '\'' +
                ", DeliveryDate='" + DeliveryDate + '\'' +
                ", ArriavalTime='" + ArriavalTime + '\'' +
                ", DeliveryFee='" + DeliveryFee + '\'' +
                ", Stetus='" + Stetus + '\'' +
                ", OrderID='" + OrderID + '\'' +
                '}';
    }
}
