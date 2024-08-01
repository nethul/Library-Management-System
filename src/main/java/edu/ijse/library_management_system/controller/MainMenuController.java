package edu.ijse.library_management_system.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainMenuController {
      @FXML
    private AnchorPane root;

    @FXML
    void btnBooksOnAction(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/edu/ijse/library_management_system/view/books.fxml"));
            Stage seconderyStage = new Stage();
            Scene scene = new Scene(root);
            seconderyStage.setScene(scene);
            seconderyStage.show();
            seconderyStage.setTitle("Books Menu");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnBorrowingsOnAction(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/edu/ijse/library_management_system/view/borrowings.fxml"));
            Stage seconderyStage = new Stage();
            Scene scene = new Scene(root);
            seconderyStage.setScene(scene);
            seconderyStage.show();
            seconderyStage.setTitle("Borrowings Menu");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnCategoriesOnAction(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/edu/ijse/library_management_system/view/categories.fxml"));
            Stage seconderyStage = new Stage();
            Scene scene = new Scene(root);
            seconderyStage.setScene(scene);
            seconderyStage.show();
            seconderyStage.setTitle("Categories Menu");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnMembersOnAction(ActionEvent event) throws IOException {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/edu/ijse/library_management_system/view/members.fxml"));
            Stage seconderyStage = new Stage();
            Scene scene = new Scene(root);
            seconderyStage.setScene(scene);
            seconderyStage.show();
            seconderyStage.setTitle("Members Menu");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
