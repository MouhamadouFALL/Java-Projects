package sn.umapp.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sn.umapp.model.Role;
import sn.umapp.model.User;

public class UserEditUIController {

	@FXML
	private TextField nomField;
	@FXML
	private TextField prenomField;
	@FXML
	private TextField emailField;
	@FXML
	private TextField telephoneField;
	@FXML
	private TextField loginField;
	@FXML
	private PasswordField passwordField;
	@FXML
	private ComboBox<String> roleComboBox;
	
	private Stage dialogStage;
	private User user;
	private boolean validerClicked;
	
	
	@FXML
	private void initialize() {
		roleComboBox.getItems().clear();
		roleComboBox.getItems().addAll(Role.ADMINISTRATEUR.getValue(), Role.SIMPLE_USER.getValue());
	}
	
	public void setDialogStage(Stage Dialog) {
		this.dialogStage = Dialog;
	}
	
	public void setUser(User user) {
		
		this.user = user;
		
		nomField.setText(user.getNom());
		prenomField.setText(user.getPrenom());
		emailField.setText(user.getEmail());
		telephoneField.setText(user.getTelephone());
		loginField.setText(user.getLogin());
		passwordField.setText(user.getPassword());
		roleComboBox.getSelectionModel().select(user.getRole());
	}
	
	//Called when the clicks on button valider
	@FXML
	private void handleValider() {
		
		if (isInputValid()) {
			
			user.setNom(nomField.getText());
			user.setPrenom(prenomField.getText());
			user.setEmail(emailField.getText());
			user.setTelephone(telephoneField.getText());
			user.setLogin(loginField.getText());
			user.setPassword(passwordField.getText());
			user.setRole(roleComboBox.getSelectionModel().getSelectedItem());
			
			validerClicked = true;
			dialogStage.close();
		}	
	}
	
	// Called when the user clicks on Annuler button
	@FXML
	private void handleAnnuler() {
		validerClicked = false;
		dialogStage.close();
	}
	
	// Validates the user input in the text fields.
	private boolean isInputValid() {
		String errorMessage = "";
		
		if (nomField.getText() == null || nomField.getText().length() == 0) {
			errorMessage += "Le nom n'est pas renseigné ! \n";
		}
		if (emailField.getText() == null || emailField.getText().isEmpty()) {
			errorMessage += "L'email n'est pas renseigné ! \n";
		}
		if (telephoneField.getText() == null || telephoneField.getText().isEmpty()) {
			errorMessage += "Le numero de telephone n'est pas renseigné ! \n";
		}
		
		if (errorMessage.isEmpty()) return true;
		else {
			// Show the error message
			Alert alert = new Alert(AlertType.ERROR);
			alert.initOwner(dialogStage);
			alert.setTitle("Champs non renseignés et/ou invalides !");
			alert.setHeaderText("Veillez remplir tous les champs svp !");
			alert.setContentText(errorMessage);
			
			alert.showAndWait();
			
			return false;
		}
	}
	
	public boolean isValiderClicked() {
		return validerClicked;
	}
}
