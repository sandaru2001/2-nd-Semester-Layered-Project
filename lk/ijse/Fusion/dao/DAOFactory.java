package lk.ijse.Fusion.lk.ijse.Fusion.dao;

import lk.ijse.Fusion.lk.ijse.Fusion.dao.custom.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory(){
    }

    public static DAOFactory getDaoFactory(){
        return (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;
    }

    public enum DAOTypes {
        ATTENDANCE,CUSTOMER,DELIVERY,EMPLOYEE,ITEM,ORDER
    }

    public SuperDAO getDAO(DAOTypes daoTypes){
        switch (daoTypes){
            case ATTENDANCE:
                return new AttendanceDAOImpl();
            case CUSTOMER:
                return new CustomerDAOImpl();
            case DELIVERY:
                return new DeliveryDAOImpl();
            case EMPLOYEE:
                return new EmployeeDAOImpl();
            case ITEM:
                return new ItemDAOImpl();
            case ORDER:
                return new OrderDAOImpl();
            default:
                return null;
        }
    }
}
