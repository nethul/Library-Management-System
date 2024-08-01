package edu.ijse.library_management_system.service.custom;

import java.util.ArrayList;

import edu.ijse.library_management_system.dto.OrderDto;
import edu.ijse.library_management_system.dto.OrderTMDto;
import edu.ijse.library_management_system.service.SuperService;

public interface OrderTMService extends SuperService {
    String saveOrder(OrderTMDto orderTMDto) throws Exception;
    String updateOrder(OrderTMDto orderTMDto);
    String deleteOrder(String orderId);
    OrderDto get(String orderId);
    ArrayList<OrderTMDto> getAll() throws Exception;
}
