package edu.ijse.library_management_system.dao;

import java.util.ArrayList;


public interface CrudDao<T, Object> extends SuperDao {
    boolean save(T t) throws Exception;
    boolean update(T t);
    boolean delete(Object... id);
    T get(Object... args) throws Exception;
    ArrayList<T> getAll();  
}
