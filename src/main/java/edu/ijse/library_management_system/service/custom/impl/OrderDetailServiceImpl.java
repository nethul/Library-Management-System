package edu.ijse.library_management_system.service.custom.impl;

import java.util.ArrayList;

import edu.ijse.library_management_system.dao.DaoFactory;
import edu.ijse.library_management_system.dao.custom.OrderDetailDao;
import edu.ijse.library_management_system.dto.OrderDetailDto;
import edu.ijse.library_management_system.entity.OrderDetailEntity;
import edu.ijse.library_management_system.service.custom.OrderDetailService;

public class OrderDetailServiceImpl implements OrderDetailService {
    OrderDetailDao orderDetailDao =(OrderDetailDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.ORDER_DETAIL);
    @Override
    public String saveOrderDetail(OrderDetailDto orderDetailDto) throws Exception {
        return orderDetailDao.save(getOrderDetailEntity(orderDetailDto)) == true ? "Success" : "Failed";

    }

    @Override
    public String updateOrderDetail(OrderDetailDto orderDetailDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateOrderDetail'");
    }

    @Override
    public String deleteOrderDetail(String orderId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteOrderDetail'");
    }

    @Override
    public OrderDetailDto get(String orderId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public ArrayList<OrderDetailDto> getAll() throws Exception {
        ArrayList<OrderDetailDto> orderDetailDtos = new ArrayList<>();
        ArrayList<OrderDetailEntity> orderDetailEntities = orderDetailDao.getAll();
        for (OrderDetailEntity orderDetailEntity : orderDetailEntities) {
            orderDetailDtos.add(getOrderDetailDto(orderDetailEntity));
        }
        return orderDetailDtos;

    }

    private OrderDetailEntity getOrderDetailEntity(OrderDetailDto orderDetailDto){
        OrderDetailEntity orderDetailEntity = new OrderDetailEntity(orderDetailDto.getOrderId(), orderDetailDto.getBookId());
        return orderDetailEntity;
    }

    private OrderDetailDto getOrderDetailDto(OrderDetailEntity orderDetailEntity){
        OrderDetailDto orderDetailDto = new OrderDetailDto(orderDetailEntity.getOrderId(), orderDetailEntity.getBookId());
        return orderDetailDto;
    }

}
