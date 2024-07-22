package edu.ijse.library_management_system.dao;

import edu.ijse.library_management_system.dao.custom.impl.AdminDaoImpl;
import edu.ijse.library_management_system.dao.custom.impl.MemberDaoImpl;

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
            default: return null;
                
        }
    }

    public enum DaoTypes{
        ADMIN, MEMBER, BOOK
    }
}
