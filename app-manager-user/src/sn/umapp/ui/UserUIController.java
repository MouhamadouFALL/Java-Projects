package sn.umapp.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import sn.umapp.UMApplication;
import sn.umapp.model.User;

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
	
	// Constructeur
	public UserUIController() {}
	
	/*
	 * Initializes the controller class. This method is automatically called 
	 * after the fxml file has been loaded
	 */
	@FXML
	public void initialize() {
		// initializes the users table
		nomColumn.setCellValueFactory(cellData -> cellData.getValue().getNom());
		prenomColumn.setCellValueFactory(cellData -> cellData.getValue().getPrenom());
		
		// add observable list data to the Table
		userTable.setItems(UMApplication.getInstance().getDataSource().getUsers());
	}
	

}
