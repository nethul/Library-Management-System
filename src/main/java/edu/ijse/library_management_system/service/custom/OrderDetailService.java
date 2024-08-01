package edu.ijse.library_management_system.service.custom;

import java.util.ArrayList;

import edu.ijse.library_management_system.dto.OrderDetailDto;
import edu.ijse.library_management_system.service.SuperService;

public interface OrderDetailService extends SuperService {
    String saveOrderDetail(OrderDetailDto orderDto) throws Exception;
    String updateOrderDetail(OrderDetailDto orderDto);
    String deleteOrderDetail(String orderId);
    OrderDetailDto get(String orderId) throws Exception;
    ArrayList<OrderDetailDto> getAll() throws Exception;
}
