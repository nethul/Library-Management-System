package edu.ijse.library_management_system.service.custom;

import java.util.ArrayList;

import edu.ijse.library_management_system.dto.CategoryDto;
import edu.ijse.library_management_system.service.SuperService;

public interface CategoryService extends SuperService {
    String saveCategory(CategoryDto categoryDto) throws Exception;
    String updateCategory(CategoryDto categoryDto) throws Exception;
    String deleteCategory(String categoryId) throws Exception;
    CategoryDto get(String categoryId);
    ArrayList<CategoryDto> getAll() throws Exception;
}
