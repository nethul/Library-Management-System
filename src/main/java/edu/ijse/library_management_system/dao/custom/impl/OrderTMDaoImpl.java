package edu.ijse.library_management_system.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;

import edu.ijse.library_management_system.dao.CrudUtil;
import edu.ijse.library_management_system.dao.custom.OrderTMDao;
import edu.ijse.library_management_system.entity.OrderTMEntity;

public class OrderTMDaoImpl implements OrderTMDao {

    @Override
    public boolean save(OrderTMEntity t) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public boolean update(OrderTMEntity t) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean delete(String id) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public OrderTMEntity get(String... args) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public ArrayList<OrderTMEntity> getAll() throws Exception {
        ArrayList<OrderTMEntity> orderTMEntities = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("SELECT orders.order_id, orders.member_id,orderdetails.book_id, orders.borrowed_date, orders.due_date FROM orders INNER JOIN orderdetails ON orders.order_id = orderdetails.order_id;");
        
        while(rst.next()){
            OrderTMEntity orderTMEntity = new OrderTMEntity(rst.getString("order_id"), rst.getString("member_id"), rst.getString("book_id"), rst.getDate("borrowed_date"), rst.getDate("due_date"));
            orderTMEntities.add(orderTMEntity);
        }
        return orderTMEntities;
    }

}
