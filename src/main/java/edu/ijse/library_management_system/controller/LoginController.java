package edu.ijse.library_management_system.controller;

import java.io.IOException;

import edu.ijse.library_management_system.dto.AdminDto;

import edu.ijse.library_management_system.service.ServiceFactory;
import edu.ijse.library_management_system.service.custom.AdminService;




import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class LoginController {
    
    AdminService adminService = (AdminService)ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.ADMIN);

    @FXML
    private JFXButton btnLogin;

    @FXML
    private JFXButton btnSignup;

    @FXML
    private AnchorPane root;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtUsername;

    @FXML
    void btnSignupOnAction(ActionEvent event) throws IOException {
        this.root.getChildren().clear();
        Parent node = FXMLLoader.load(getClass().getResource("/edu/ijse/library_management_system/view/signup.fxml"));
        this.root.getChildren().add(node);
        //new Admin("nethNana", "Nethul Nanayakkara", "Nethul2005");

    }

    @FXML
    void btnLoginOnAction(ActionEvent event) {
        try {
            AdminDto adminDto = adminService.get(txtUsername.getText(), txtPassword.getText());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Welcome");
            alert.setHeaderText("Login successfull");
            alert.setContentText("Hello" + " " + adminDto.getName());
            alert.showAndWait();
            
            this.root.getChildren().clear();
            Parent node = FXMLLoader.load(getClass().getResource("/edu/ijse/library_management_system/view/mainMenu.fxml"));
            this.root.getChildren().add(node);
            
        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error at logging in");
            alert.setContentText("Please make sure that your login credentials are correct.");
            alert.showAndWait();
        }
        
        
        
    }
}
