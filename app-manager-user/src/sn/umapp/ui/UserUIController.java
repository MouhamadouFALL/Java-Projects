package sn.umapp.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
		
		// Clear the user details form
		displayUserDetails(null);
		
		// add a ChangeListener to the userTable
		addChangeListener();
	}
	
	
	/**
	 * Fills all text fields to shows details about the user
	 * If the specified user is null all text fields are cleared
	 * 
	 * @param user
	 */
	private void displayUserDetails(User user) {
		
		if (user != null) {
			// Fill the labels with info from the User object
			this.nomLabel.setText(user.getNom().get());
			this.prenomLabel.setText(user.getPrenom().get());
			this.emailLabel.setText(user.getEmail().get());
			this.telephoneLabel.setText(user.getTelephone().get());
			this.loginLabel.setText(user.getLogin().get());
			this.passwordLabel.setText(user.getPassword().get());
			this.roleLabel.setText(user.getRole().get());
		}
		else {
			// User is null, remove all the text
			this.nomLabel.setText(null);
			this.prenomLabel.setText(null);
			this.emailLabel.setText(null);
			this.telephoneLabel.setText(null);
			this.loginLabel.setText(null);
			this.passwordLabel.setText(null);
			this.roleLabel.setText(null);
		}
	}
	
	/**
	 * Surveille les changements sur la table et affiche les informations dans le formulaire
	 */
	private void addChangeListener() {
		
		userTable.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldValue, newValue) ->  displayUserDetails(newValue)
				);
	}
	
	/**
	 * Called when the user clicks one the delete button
	 */
	@FXML
	private void handleDeleteUser() {
		// recuperer l'index de l'utilisateur selectionné puis le supprimer de la liste
		int selectedIndex = userTable.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0) {
			userTable.getItems().remove(selectedIndex);
			
		}
		else {
			// si aucun utilisateur n'est sélectionné afficher un message alerte
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Warning ...");
			alert.setHeaderText("Alerte !");
			alert.setContentText("Veillez selectionner l'utilisateur à supprimé");
			
			alert.showAndWait();
		}
	}
	
	@FXML
	private void handleNewUSer() {
		User user = new User();
		
		boolean validerClicked = UMApplication.getInstance().showUserEditUI(user);
		if (validerClicked) {
			UMApplication.getInstance().getDataSource().getUsers().add(user);
		}
	}
	
	@FXML
	private void handleUpdateUser() {
		
		User selectedUser = userTable.getSelectionModel().getSelectedItem();
		int indexUser = userTable.getSelectionModel().getSelectedIndex();
		
		if (selectedUser != null) {
			boolean validerClicked = UMApplication.getInstance().showUserEditUI(selectedUser);
			if (validerClicked) {
				displayUserDetails(selectedUser);
				userTable.getItems().remove(indexUser);
				userTable.getItems().add(indexUser, selectedUser);
				//UMApplication.getInstance().getDataSource().getUsers().add(indexUser, selectedUser);
			}
		}
		else {
			// Nothing selected
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Aucune sélection");
			alert.setHeaderText("Aucun utilisateur n'a été sélectionné !");
			alert.setContentText("Veillez choisir un user svp !");
			
			alert.showAndWait();
		}
	}

}
