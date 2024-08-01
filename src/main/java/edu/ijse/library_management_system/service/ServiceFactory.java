package edu.ijse.library_management_system.service;

import edu.ijse.library_management_system.service.custom.impl.AdminServiceImpl;
import edu.ijse.library_management_system.service.custom.impl.BookServiceImpl;
import edu.ijse.library_management_system.service.custom.impl.CategoryServiceImpl;
import edu.ijse.library_management_system.service.custom.impl.MemberServiceImpl;
import edu.ijse.library_management_system.service.custom.impl.OrderDetailServiceImpl;
import edu.ijse.library_management_system.service.custom.impl.OrderServiceImpl;

public class ServiceFactory {
    private static ServiceFactory serviceFactory;

    public static ServiceFactory getInstance(){
        if (serviceFactory == null){
            serviceFactory = new ServiceFactory();
        }
        return serviceFactory;
    }

    public SuperService getService(ServiceType serviceType){
        switch (serviceType) {
            case ADMIN : return new AdminServiceImpl(); 
            case MEMBER : return new MemberServiceImpl();
            case CATEGORY : return new CategoryServiceImpl();
            case BOOK : return new BookServiceImpl();
            case ORDER : return new OrderServiceImpl();
            case ORDER_DETAIL : return new OrderDetailServiceImpl();
            default : return null;
            }
    }
    
    public enum ServiceType{
        ADMIN, MEMBER, CATEGORY, BOOK , ORDER, ORDER_DETAIL
    }
}
