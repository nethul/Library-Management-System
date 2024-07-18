package edu.ijse.library_management_system.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;

import edu.ijse.library_management_system.dto.AdminDto;
import edu.ijse.library_management_system.service.ServiceFactory;
import edu.ijse.library_management_system.service.custom.AdminService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class SignupController {

    AdminService adminService =(AdminService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.ADMIN);

     @FXML
    private AnchorPane root;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtUserName;

    @FXML
    void btnLoginOnAction(ActionEvent event) throws IOException {
        this.root.getChildren().clear();
        Parent node = FXMLLoader.load(getClass().getResource("/edu/ijse/library_management_system/view/login.fxml"));
        this.root.getChildren().add(node);
    }

    @FXML
    void btnSignupOnAction(ActionEvent event) {
        try {
            AdminDto adminDto = new AdminDto(txtUserName.getText(), txtName.getText(), txtPassword.getText());
            String resp = adminService.saveAdmin(adminDto);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle(resp);
            alert.setHeaderText("Successfully registered as an Admin");
            alert.setContentText("Now you can proceed with login");
            alert.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText("Error at saving Admin details");
            alert.setContentText("Please make sure that all the details are inputted correctly.");
            alert.showAndWait();
        }
        
    }
}
