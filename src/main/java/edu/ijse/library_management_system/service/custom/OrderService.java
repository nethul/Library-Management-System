package edu.ijse.library_management_system.service.custom;

import java.util.ArrayList;

import edu.ijse.library_management_system.dto.OrderDto;
import edu.ijse.library_management_system.service.SuperService;

public interface OrderService extends SuperService {
    String saveOrder(OrderDto orderDto) throws Exception;
    String updateOrder(OrderDto orderDto);
    String deleteOrder(String orderId) throws Exception;
    OrderDto get(String orderId);
    ArrayList<OrderDto> getAll() throws Exception;
}
