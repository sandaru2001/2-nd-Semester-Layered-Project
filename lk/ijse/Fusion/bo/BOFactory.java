package lk.ijse.Fusion.lk.ijse.Fusion.bo;

import lk.ijse.Fusion.lk.ijse.Fusion.bo.custom.impl.*;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory(){
    }
    public static BOFactory getBoFactory(){
        return (boFactory == null) ? boFactory = new BOFactory() : boFactory;
    }

    public enum BOTypes{
        ATTENDANCE,CUSTOMER,DELIVERY,EMPLOYEE,ITEM,ORDER
    }

    public SuperBO getBO(BOTypes types){
        switch (types){
            case ATTENDANCE:
                return new AttendanceBOImpl();
            case CUSTOMER:
                return new CustomerBOImpl();
            case DELIVERY:
                return new DeliveryBOImpl();
            case EMPLOYEE:
                return new EmployeeBOImpl();
            case ITEM:
                return new ItemBOImpl();
            case ORDER:
                return new OrderBOImpl();
            default:
                return null;
        }
    }
}
