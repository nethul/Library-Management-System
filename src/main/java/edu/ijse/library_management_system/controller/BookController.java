package edu.ijse.library_management_system.controller;

import java.security.Provider.Service;
import java.util.ArrayList;

import edu.ijse.library_management_system.dto.BookDto;
import edu.ijse.library_management_system.dto.CategoryDto;
import edu.ijse.library_management_system.service.ServiceFactory;
import edu.ijse.library_management_system.service.custom.BookService;
import edu.ijse.library_management_system.service.custom.CategoryService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class BookController {
    CategoryService categoryService = (CategoryService)ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.CATEGORY); 
    BookService bookService =(BookService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.BOOK);
    @FXML
    private ComboBox<CategoryDto> comboBoxCategory;

    @FXML
    private AnchorPane root;

    @FXML
    private TableView<BookDto> tblBooks;

    @FXML
    private TextField txtAuthor;

    @FXML
    private TextField txtBookId;

    @FXML
    private TextField txtBookName;

    @FXML
    private TableColumn<BookDto, String> colAuthor;

    @FXML
    private TableColumn<BookDto, String> colCategory;

    @FXML
    private TableColumn<BookDto, String> colId;

    @FXML
    private TableColumn<BookDto, String> colName;


    @FXML
    public void initialize(){
        try {
            colId.setCellValueFactory(new PropertyValueFactory<>("bookId"));
            colCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
            colName.setCellValueFactory(new PropertyValueFactory<>("bookName"));
            colAuthor.setCellValueFactory(new PropertyValueFactory<>("Author"));
            loadTable();
            ArrayList<CategoryDto> categoryDtos = categoryService.getAll();
            ObservableList<CategoryDto> observableArrayList = FXCollections.observableArrayList();
        for (CategoryDto categoryDto : categoryDtos) {
            observableArrayList.add(categoryDto);
        }
        comboBoxCategory.setItems(observableArrayList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    private void loadTable() {
        try {
            
            ObservableList<BookDto> observableArrayList = FXCollections.observableArrayList();
            ArrayList<BookDto> bookDtos = bookService.getAll();
            for (BookDto bookDto : bookDtos) {
                observableArrayList.add(bookDto);
            }
            tblBooks.setItems(observableArrayList);

        } catch (Exception e) {
             Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error at loading table");
            //alert.setContentText("Please make sure that your details are correct");
            alert.showAndWait();
            e.printStackTrace();
        }
       
    }

    @FXML
    void btnAddBookOnAction(ActionEvent event) {
        try {
            BookDto bookDto = new BookDto(txtBookId.getText(), comboBoxCategory.getSelectionModel().getSelectedItem().getCategoryId(), txtBookName.getText(), txtAuthor.getText());  
            String resp = bookService.addBook(bookDto);
            loadTable();
            clearForm();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle(resp);
            alert.setHeaderText("Book saved Successfully");
            //alert.setContentText("Please make sure that your details are correct");
            alert.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Book save failed");
            //alert.setContentText("Please make sure that your details are correct");
            alert.showAndWait();
        }
        
        
    }

    private void clearForm() {
        txtBookId.clear();
        txtBookName.clear();
        txtAuthor.clear();
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        try {
            String resp = bookService.deleteBook(txtBookId.getText());
            loadTable();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle(resp);
            alert.setHeaderText("Book Dleted Successfully");
            //alert.setContentText("Please make sure that your details are correct");
            alert.showAndWait();

        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Book Deletion failed");
            //alert.setContentText("Please make sure that your details are correct");
            alert.showAndWait();
        }
        
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        try {
            BookDto bookDto = new BookDto(txtBookId.getText(), comboBoxCategory.getSelectionModel().getSelectedItem().getCategoryId(), txtBookName.getText() , txtAuthor.getText());
            String resp = bookService.updateBook(bookDto);;
            loadTable();
            clearForm();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle(resp);
            alert.setHeaderText("Book updated successfully");
            //alert.setContentText("Please make sure that your details are correct");
            alert.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error at updating book");
            //alert.setContentText("Please make sure that your details are correct");
            alert.showAndWait();
        }
        
    }

    @FXML
    void loadBooksToTextFields(MouseEvent event) {
        BookDto selectedItem = tblBooks.getSelectionModel().getSelectedItem();
        txtBookId.setText(selectedItem.getBookId());
        comboBoxCategory.setValue(categoryService.get(selectedItem.getCategory()));
        // comboBoxCategory.setVisible(true);
        txtBookName.setText(selectedItem.getBookName());
        txtAuthor.setText(selectedItem.getAuthor());
    }

    @FXML
    void comboBoxCategoryClicked(MouseEvent event) {
        initialize();
    }
}
