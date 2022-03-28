package sn.umapp;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class UMApplication extends Application {
	
	private Stage primaryStage;
	private BorderPane mainUI;
	private AnchorPane userUI;
	
	private static UMApplication instance;
	
	
	public static void main(String[] args) {
		launch(args);
	}
	

	@Override
	public void start(Stage primaryStage) {
		
		instance = this;
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("User Management System");
		
	}
	
	public void initRootLayout() {
		try {
			
			//Load root layout from fxml file
			mainUI = (BorderPane) FXMLLoader.load(getClass().getResource("ui/MainUI.fxml"));
			
			//Show the scene containning the root layout
			Scene scene = new Scene(mainUI);
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch (IOException e) {
			System.err.println("Erreru lors du chargement : " + e.getMessage()); 
			//e.printStackTrace();
		}
	}
	
	public void showUserUI() {
		
		try {
			userUI = (AnchorPane) FXMLLoader.load(getClass().getResource("ui/UserUI"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
