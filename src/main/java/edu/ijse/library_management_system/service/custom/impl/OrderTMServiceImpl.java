package edu.ijse.library_management_system.service.custom.impl;

import java.util.ArrayList;

import edu.ijse.library_management_system.dao.DaoFactory;
import edu.ijse.library_management_system.dao.custom.OrderTMDao;
import edu.ijse.library_management_system.dto.OrderDto;
import edu.ijse.library_management_system.dto.OrderTMDto;
import edu.ijse.library_management_system.entity.OrderTMEntity;
import edu.ijse.library_management_system.service.custom.OrderTMService;

public class OrderTMServiceImpl implements OrderTMService {
    OrderTMDao orderTMDao =(OrderTMDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.ORDERTM);

    @Override
    public String saveOrder(OrderTMDto orderTMDto) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveOrder'");
    }

    @Override
    public String updateOrder(OrderTMDto orderTMDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateOrder'");
    }

    @Override
    public String deleteOrder(String orderId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteOrder'");
    }

    @Override
    public OrderDto get(String orderId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public ArrayList<OrderTMDto> getAll() throws Exception {
        ArrayList<OrderTMDto> orderTMDtos = new ArrayList<>();
        ArrayList<OrderTMEntity> orderTMEntities = orderTMDao.getAll();
        for (OrderTMEntity orderTMEntity : orderTMEntities) {
            orderTMDtos.add(getOrderTMDto(orderTMEntity));
        }
        return orderTMDtos;
    }

    private OrderTMDto getOrderTMDto(OrderTMEntity orderTMEntity){
        OrderTMDto orderTMDto = new OrderTMDto(orderTMEntity.getOrderId(), orderTMEntity.getMemberId(), orderTMEntity.getBookId(), orderTMEntity.getBorrowedDate(), orderTMEntity.getDueDate());
        return orderTMDto;
    }

}
