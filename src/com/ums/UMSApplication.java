package com.ums;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class UMSApplication extends Application {
	
	private Stage primaryStage;
	private BorderPane mainUI;
	private AnchorPane userUI;
	private DataSource dataSource;
	private static UMSApplication instance;


	@Override
	public void start(Stage primaryStage) {
		
		instance = this; // l'objet de la classe UMSApplication
		
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("User Management System");
		dataSource = new DataSource();
		
		initRootLayout();
		showUserUI();
	}
	
	
	// Initializes the root layout.
	public void initRootLayout() {
		try {
			// Load root layout from fxml file
			mainUI = (BorderPane) FXMLLoader.load(getClass().getResource("ui/MainUI.fxml"));
			
			// Show the scene containing the root layout.
			Scene scene = new Scene(mainUI);
			primaryStage.setScene(scene);
			primaryStage.show();
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// Show the user UI inside the root layout
	public void showUserUI() {
		try {
			// Load userUI
			userUI = (AnchorPane) FXMLLoader.load(getClass().getResource("ui/UserUI.fxml"));
			
			// Set userUI into the center of root loyout
			mainUI.setCenter(userUI);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// Returns the main stage
	public Stage getPrimaryStage() {
		return primaryStage;
	}
	
	/********************************************/
	public DataSource getDataSource() {
		return dataSource;
	}
	/*******************************************/
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	
	
	
	
	/************************************** GETTERS AND SETTERS ***************************/
	
	public static UMSApplication getInstance() {
		return instance;
	}

	public static void setInstance(UMSApplication instance) {
		UMSApplication.instance = instance;
	}
}
