package edu.ijse.library_management_system.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;

import edu.ijse.library_management_system.dao.CrudUtil;
import edu.ijse.library_management_system.dao.custom.OrderDetailDao;
import edu.ijse.library_management_system.entity.OrderDetailEntity;

public class OrderDetailDaoImpl implements OrderDetailDao {

    @Override
    public boolean save(OrderDetailEntity t) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO orderdetails VALUES (?,?)", t.getOrderId(), t.getBookId());
    }

    @Override
    public boolean update(OrderDetailEntity t) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean delete(String id) throws Exception {
       return CrudUtil.executeUpdate("DELETE FROM orderdetails WHERE order_id = ?", id);
    }

    @Override
    public OrderDetailEntity get(String... args) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public ArrayList<OrderDetailEntity> getAll() throws Exception {
                ResultSet rst = CrudUtil.executeQuery("SELECT * FROM orderdetails");
                ArrayList<OrderDetailEntity> orderDetailEntities = new ArrayList<>();
            while (rst.next()){
                OrderDetailEntity orderDetailEntity = new OrderDetailEntity(rst.getString("order_id"), rst.getString("book_id"));
                orderDetailEntities.add(orderDetailEntity);
            }
        return orderDetailEntities;

    }

    // @Override
    // public ArrayList<OrderDetailEntity> getAll() throws Exception {
    //     ResultSet rst = CrudUtil.executeQuery("SELECT * FROM orderdetails");
    //     ArrayList<OrderDetailEntity> orderDetailEntities = new ArrayList<>();
    //     while (rst.next()){
    //         OrderDetailEntity orderDetailEntity = new OrderDetailEntity(rst.getString("order_id"), rst.getString("book_id"));
    //         orderDetailEntities.add(orderDetailEntity);
    //     }
    //     return orderDetailEntities;

    // }

}
