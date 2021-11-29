package com.ums.ui;

import com.ums.UMSApplication;
import com.ums.model.User;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class UserUIController {
	
	@FXML
	private TableView<User> userTable;
	@FXML
	private TableColumn<User, String> nomColumn;
	@FXML
	private TableColumn<User, String> prenomColumn;
	@FXML
	private Label nomLabel;
	@FXML
	private Label prenomLabel; 
	@FXML
	private Label emailLabel; 
	@FXML
	private Label telephoneLabel; 
	@FXML
	private Label loginLabel; 
	@FXML
	private Label passwordLabel;
	@FXML
	private Label roleLabel;

	
	// The data source
	//private DataSource dataSource;

	
	// Constructor
	public UserUIController() {  }
	
	/**
	 * Initializes the controller class. This method 	is automatically called
	 * after the fxml file has been loaded
	 */
	
	
	@FXML
	private void initialize() {
			
		// Initialise la table des utilisateurs 
		nomColumn.setCellValueFactory(cellData -> cellData.getValue().getNom());
		prenomColumn.setCellValueFactory(cellData -> cellData.getValue().getPrenom());
		
		// Add observable list data to the table 
		userTable.setItems(UMSApplication.getInstance().getDataSource().getUsers());
	}


}
