package edu.ijse.library_management_system.dao;

import java.util.ArrayList;


@SuppressWarnings("hiding")
public interface CrudDao<T, Object> extends SuperDao {
    boolean save(T t) throws Exception;
    boolean update(T t) throws Exception;
    boolean delete(@SuppressWarnings("unchecked") Object... id) throws Exception;
    T get(@SuppressWarnings("unchecked") Object... args) throws Exception;
    ArrayList<T> getAll() throws Exception;  
}
