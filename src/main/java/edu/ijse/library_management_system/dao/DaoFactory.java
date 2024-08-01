package edu.ijse.library_management_system.dao;

import edu.ijse.library_management_system.dao.custom.impl.AdminDaoImpl;
import edu.ijse.library_management_system.dao.custom.impl.BookDaoImpl;
import edu.ijse.library_management_system.dao.custom.impl.CategoryDaoImpl;
import edu.ijse.library_management_system.dao.custom.impl.MemberDaoImpl;
import edu.ijse.library_management_system.dao.custom.impl.OrderDaoImpl;
import edu.ijse.library_management_system.dao.custom.impl.OrderDetailDaoImpl;
import edu.ijse.library_management_system.dao.custom.impl.OrderTMDaoImpl;

public class DaoFactory {
    private static DaoFactory daoFactory;

    public static DaoFactory getInstance(){
        if (daoFactory == null){
            daoFactory = new DaoFactory();
        }
        return daoFactory;
    }

    public SuperDao getDao(DaoTypes daoType){
        switch (daoType) {
            case ADMIN : return new AdminDaoImpl();
            case MEMBER : return new MemberDaoImpl();
            case CATEGORY : return new CategoryDaoImpl();
            case BOOK : return new BookDaoImpl();
            case ORDER : return new OrderDaoImpl();
            case ORDER_DETAIL : return new OrderDetailDaoImpl();
            case ORDERTM : return new OrderTMDaoImpl();
            default: return null;
                
        }
    }

    public enum DaoTypes{
        ADMIN, MEMBER, CATEGORY, BOOK, ORDER, ORDER_DETAIL, ORDERTM
    }
}
