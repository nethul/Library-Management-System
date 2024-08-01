package edu.ijse.library_management_system.service.custom.impl;

import java.util.ArrayList;

import edu.ijse.library_management_system.dao.DaoFactory;
import edu.ijse.library_management_system.dao.custom.CategoryDao;
import edu.ijse.library_management_system.dto.CategoryDto;
import edu.ijse.library_management_system.entity.CategoryEntity;
import edu.ijse.library_management_system.service.custom.CategoryService;

public class CategoryServiceImpl implements CategoryService {

    CategoryDao categoryDao = (CategoryDao)DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.CATEGORY);

    @Override
    public String saveCategory(CategoryDto categoryDto) throws Exception {
        return categoryDao.save(getCategoryEntity(categoryDto)) == true ? "Success" : "Fail";
    }

    @Override
    public String updateCategory(CategoryDto categoryDto) throws Exception {
       return categoryDao.update(getCategoryEntity(categoryDto)) == true ? "Success" : "Failed";
       
    }

    @Override
    public String deleteCategory(String categoryId) throws Exception {
        return categoryDao.delete(categoryId) == true ? "Success" : "Failed";

    }

    @Override
    public CategoryDto get(String categoryId) {
        return null;
    }

    @Override
    public ArrayList<CategoryDto> getAll() throws Exception {
        ArrayList<CategoryEntity> categoryEntities = categoryDao.getAll();
        ArrayList<CategoryDto> categoryDtos = new ArrayList<>();

        for (CategoryEntity categoryEntity : categoryEntities) {
            categoryDtos.add(getCategoryDto(categoryEntity));
        }
        return categoryDtos;
    }

    private CategoryEntity getCategoryEntity(CategoryDto categoryDto){
        return new CategoryEntity(categoryDto.getCategoryId(), categoryDto.getCategoryName());
    }

    private CategoryDto getCategoryDto(CategoryEntity categoryEntity){
        return new CategoryDto(categoryEntity.getCategoryId(), categoryEntity.getCategoryName());
    }

}
