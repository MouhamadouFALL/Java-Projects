package sn.umapp.ui;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import sn.umapp.DataSource;
import sn.umapp.UMApplication;
import sn.umapp.db.UMADBException;
import sn.umapp.db.dao.UserDaoImpl;
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
	
	@FXML
	private TextField rechercheTextField;
	
	DataSource source;
	
	ObservableList<User> users;
	
	// Constructeur
	public UserUIController() {
		// charger les utilisateurs dans la collection users
		source = UMApplication.getInstance().getDataSource();
	}
	
	/*
	 * Initializes the controller class. This method is automatically called 
	 * after the fxml file has been loaded
	 */
	@FXML
	public void initialize() {
		
		users = source.getUsers();
		
		// initializes the users table
		nomColumn.setCellValueFactory(cellData -> cellData.getValue().getNom());
		prenomColumn.setCellValueFactory(cellData -> cellData.getValue().getPrenom());
		
		// 1-Envelopper ObservableList dans un FilteredList ( Afficher initialement toutes les données )
		FilteredList <User> filteredData = new FilteredList<>(users, u -> true);
		
		// 2 - Définir le filtre prédicat chaque fois que le filtre change
		rechercheTextField.textProperty().addListener(
				(observable, oldValue, newValue) -> {
					filteredData.setPredicate(user -> {
						// If rechercheTextField is empty, display all users
						if (newValue == null || newValue.isEmpty()) {
							return true;
						}
						
						// Compare first name and last name of every user with the filter text
						String chaineRecherche = newValue.toLowerCase();
						
						if (user.getPrenom().get().toLowerCase().contains(chaineRecherche)) {
							return true; // Filter matches first name == filtre correspond au prenom
						}
						else if (user.getNom().get().toLowerCase().contains(chaineRecherche)) {
							return true; // Filter matches last name == filtre correspond au nom
						}
						return false; //Does not match
					});
				}
			);
		
		// 3-Envelopper le FilteredList dans un SortedList.
		SortedList<User> sortedData = new SortedList<>(filteredData);
		
		
		// 4-  Bind The SortedList comparator to the TableView comparator
		sortedData.comparatorProperty().bind(userTable.comparatorProperty());
		
		//5- Add sorted (and filtered) data to the table
		userTable.setItems(sortedData);
		
		// add observable list data to the Table
		//userTable.setItems(UMApplication.getInstance().getDataSource().getUsers());
		
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
		int idUser = userTable.getSelectionModel().getSelectedItem().getIdUser();
		
		if (idUser > 0) {
			
			try {
				
				source.deleteUser(idUser);
				users.remove(selectedIndex);
				
			} 
			catch (UMADBException e) {
				System.err.println(e.getMessage());
			}
			
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
			
			try {
				source.add(user);
				initialize();
			} 
			catch (UMADBException e) {
				System.err.println(e.getMessage());
			}
			
			
		}
	}
	
	@FXML
	private void handleUpdateUser() {
		
		User selectedUser = userTable.getSelectionModel().getSelectedItem();
		
		if (selectedUser != null) {
			
			boolean validerClicked = UMApplication.getInstance().showUserEditUI(selectedUser);
			
			if (validerClicked) {
				
				try {
					
					source.update(selectedUser);
					displayUserDetails(selectedUser);
					userTable.refresh();
					
				}
				catch (UMADBException e) {
					System.err.println(e.getMessage());
				}
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
