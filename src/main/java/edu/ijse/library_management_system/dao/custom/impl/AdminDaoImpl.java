package edu.ijse.library_management_system.dao.custom.impl;


import java.sql.ResultSet;
import java.util.ArrayList;

import edu.ijse.library_management_system.dao.CrudUtil;
import edu.ijse.library_management_system.dao.custom.AdminDao;
import edu.ijse.library_management_system.entity.AdminEntity;

public class AdminDaoImpl implements AdminDao {
    @Override
    public boolean save(AdminEntity adminEntity) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO Admin VALUES (?,?,?)", adminEntity.getUserName(), adminEntity.getName(), adminEntity.getPassword());
    }

    @Override
    public boolean update(AdminEntity t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean delete(String args) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public AdminEntity get(String... args) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM Admin WHERE username = ?", args[0]);
    while (rst.next()){
            if(rst.getString("password").equals(args[1])){
                AdminEntity adminEntity = new AdminEntity(rst.getString("username"), rst.getString("full_name"), rst.getString("password"));
                return adminEntity;
            }
           
        }
        return null;
    }

    @Override
    public ArrayList<AdminEntity> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

}
