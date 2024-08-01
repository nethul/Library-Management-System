package edu.ijse.library_management_system.controller;

import java.util.ArrayList;

import edu.ijse.library_management_system.dto.CategoryDto;
import edu.ijse.library_management_system.service.ServiceFactory;
import edu.ijse.library_management_system.service.custom.CategoryService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;


public class CategoryController {
    
    @FXML
    public void initialize(){
        colId.setCellValueFactory(new PropertyValueFactory<>("categoryId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("categoryName")); 
    try {
        loadTable();
    } catch (Exception e) {
        e.printStackTrace();
    }
    
    }

    private void loadTable() throws Exception {
        ObservableList<CategoryDto> observableArrayList = FXCollections.observableArrayList();
        ArrayList<CategoryDto> categoryDtos = categoryService.getAll();
        for (CategoryDto categoryDto : categoryDtos) {
            observableArrayList.add(categoryDto);
        }
        tblCategory.setItems(observableArrayList);
    }

    CategoryService categoryService = (CategoryService)ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.CATEGORY);
    
    @FXML
    private TableColumn<CategoryDto, String> colId;

    @FXML
    private TableColumn<CategoryDto, String> colName;

    @FXML
    private TableView<CategoryDto> tblCategory;

    @FXML
    private TextField txtCategoryId;

    @FXML
    private TextField txtCategoryName;

    @FXML
    void btnAddCategoryOnAction(ActionEvent event) {
        try {
            CategoryDto categoryDto = new CategoryDto(txtCategoryId.getText(), txtCategoryName.getText());
            String resp =categoryService.saveCategory(categoryDto);
            loadTable();
            clearForm();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle(resp);
            alert.setHeaderText("Category added successfully");
            alert.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Failed");
            alert.setHeaderText("Error while adding the category");
            alert.showAndWait();
        }
    }

    private void clearForm() {
        txtCategoryId.clear();
        txtCategoryName.clear();
    }

    @FXML
    void btnDeleteCategoryOnAction(ActionEvent event) {
        try {
            String resp = categoryService.deleteCategory(txtCategoryId.getText());
            loadTable();
            clearForm();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle(resp);
            alert.setHeaderText("Category deleted successfully");
            alert.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Failed");
            alert.setHeaderText("Error while deleting category");
            alert.showAndWait();
        }
    }

    @FXML
    void btnUpdateCategoryOnAction(ActionEvent event) {
        try {
            CategoryDto categoryDto = new CategoryDto(txtCategoryId.getText(), txtCategoryName.getText());
            String resp = categoryService.updateCategory(categoryDto);
            loadTable();
            clearForm();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle(resp);
            alert.setHeaderText("Category Updated Successfully");
            alert.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Failed");
            alert.setHeaderText("Error while updating category");
            alert.showAndWait();
        }
        
    }

    @FXML
    void loadTextFields(MouseEvent event) {
        CategoryDto selectedCategory = tblCategory.getSelectionModel().getSelectedItem();
        txtCategoryId.setText(selectedCategory.getCategoryId());
        txtCategoryName.setText(selectedCategory.getCategoryName());
    }




}
