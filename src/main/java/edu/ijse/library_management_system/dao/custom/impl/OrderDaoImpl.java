package edu.ijse.library_management_system.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;

import edu.ijse.library_management_system.dao.CrudUtil;
import edu.ijse.library_management_system.dao.custom.OrderDao;
import edu.ijse.library_management_system.entity.OrderEntity;

public class OrderDaoImpl implements OrderDao {

    @Override
    public boolean save(OrderEntity t) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO orders VALUES (?,?,?,?)", t.getOrderId(), t.getMemberId(), t.getDueDate(), t.getBorrowedDate());
    }

    @Override
    public boolean update(OrderEntity t) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM orders WHERE order_id = ?" , id);
    }

    @Override
    public OrderEntity get(String... args) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public ArrayList<OrderEntity> getAll() throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM orders");
        ArrayList<OrderEntity> orderEntities = new ArrayList<>();
        while(rst.next()){
            OrderEntity orderEntity = new OrderEntity(rst.getString("order_id"), rst.getString("member_id"), rst.getDate("due_date"), rst.getDate("borrowed_date"));
            orderEntities.add(orderEntity);
        }
        return orderEntities;
    }

}
