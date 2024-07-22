package edu.ijse.library_management_system;

import java.net.URL;


import org.springframework.boot.autoconfigure.SpringBootApplication;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

@SpringBootApplication
public class LibraryManagementSystemApplication extends javafx.application.Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		URL url = getClass().getResource("./view/login.fxml");
		Parent root = FXMLLoader.load(url);
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
