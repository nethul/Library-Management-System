package edu.ijse.library_management_system.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;

import edu.ijse.library_management_system.dao.CrudUtil;
import edu.ijse.library_management_system.dao.custom.CategoryDao;
import edu.ijse.library_management_system.entity.CategoryEntity;

public class CategoryDaoImpl implements CategoryDao {

    @Override
    public boolean save(CategoryEntity t) throws Exception {
       return CrudUtil.executeUpdate("INSERT INTO categories VALUES (?,?)", t.getCategoryId(), t.getCategoryName());
    }

    @Override
    public boolean update(CategoryEntity t) throws Exception {
        return CrudUtil.executeUpdate("UPDATE categories SET category_name = ? WHERE category_id = ?", t.getCategoryName(), t.getCategoryId());
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM categories WHERE category_id = ?", id);
    }

    @Override
    public CategoryEntity get(String... args) throws Exception {
        return null;
    }

    @Override
    public ArrayList<CategoryEntity> getAll() throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM categories");
        ArrayList<CategoryEntity> categoryEntities = new ArrayList<>();
        while(rst.next()){
            CategoryEntity categoryEntity = new CategoryEntity(rst.getString("category_id"), rst.getString("category_name"));
            categoryEntities.add(categoryEntity);
        }
        return categoryEntities;
    }

}
