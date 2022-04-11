package sn.umapp;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sn.umapp.db.JDBCConnection;
import sn.umapp.db.UMADBException;
import sn.umapp.model.User;
import sn.umapp.ui.UserEditUIController;

public class UMApplication extends Application {
	
	private Stage primaryStage;
	private BorderPane mainUI;
	private AnchorPane userUI;
	
	private DataSource dataSource;
	
	private static UMApplication instance;
	
	
	public static void main(String[] args) {
		launch(args);
	}
	

	@Override
	public void start(Stage primaryStage) {
		
		instance = this;
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("User Management Application");
		
		try {
			
			dataSource = new DataSource();
			
			initRootLayout();
			showUserUI();
			
		} catch (UMADBException e) {
			System.err.println(e.getMessage());
		}
		
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
			// Load UserUI
			userUI = (AnchorPane) FXMLLoader.load(getClass().getResource("ui/UserUI.fxml"));
			
			// Set userUI into the center of root Layout
			mainUI.setCenter(userUI);
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Afficher l'interface d'édition des utilisateurs
	public boolean showUserEditUI(User user) {
		
		try {
			
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(UMApplication.class.getResource("ui/UserEditUI.fxml"));
			AnchorPane page = (AnchorPane)loader.load();
			
			// create the dialogue stage
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Editer un utilisateur ( Ajouter - Modifier )");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			dialogStage.setScene(new Scene(page));
			
			UserEditUIController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setUser(user); // Set the User into the controller
			
			// show the dialog and wait until the user closes it 
			dialogStage.showAndWait();
			
			return controller.isValiderClicked();
			
			
		} catch (IOException e) {
			System.err.println(e.getMessage());
			return false;
		}
	}


	public Stage getPrimaryStage() {
		return primaryStage;
	}


	public DataSource getDataSource() {
		return dataSource;
	}
	
	public static UMApplication getInstance() {
		return instance;
	}
	
}
