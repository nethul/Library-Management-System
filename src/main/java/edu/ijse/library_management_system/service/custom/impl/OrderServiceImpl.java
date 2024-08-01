package edu.ijse.library_management_system.service.custom.impl;

import java.util.ArrayList;

import edu.ijse.library_management_system.dao.DaoFactory;
import edu.ijse.library_management_system.dao.custom.OrderDao;
import edu.ijse.library_management_system.dto.OrderDto;
import edu.ijse.library_management_system.entity.OrderEntity;
import edu.ijse.library_management_system.service.custom.OrderService;

public class OrderServiceImpl implements OrderService {
    OrderDao orderDao =(OrderDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.ORDER);

    @Override
    public String saveOrder(OrderDto orderDto) throws Exception {
        return orderDao.save(getOrderEntity(orderDto)) == true ? "Success" : "Failed";
    }

    @Override
    public String updateOrder(OrderDto orderDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateOrder'");
    }

    @Override
    public String deleteOrder(String orderId) throws Exception {
        return orderDao.delete(orderId) == true ? "Success" : "Failed";
        
    }

    @Override
    public OrderDto get(String orderId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public ArrayList<OrderDto> getAll() throws Exception {
        ArrayList<OrderEntity> orderEntities = orderDao.getAll();
        ArrayList<OrderDto> orderDtos = new ArrayList<>();
        for (OrderEntity orderEntity : orderEntities) {
            OrderDto orderDto = new OrderDto(orderEntity.getOrderId(), orderEntity.getMemberId(), orderEntity.getDueDate(), orderEntity.getBorrowedDate());
            orderDtos.add(orderDto);
        }
        return orderDtos;
        
    }

    private OrderEntity getOrderEntity(OrderDto orderDto){
        OrderEntity orderEntity = new OrderEntity(orderDto.getOrderId(), orderDto.getMemberId(), orderDto.getDueDate(), orderDto.getBorrowedDate());
        return orderEntity;
    }

}
