package sn.umapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sn.umapp.model.Role;
import sn.umapp.model.User;

public class DataSource {
	// une liste observable utilisateur
	private ObservableList<User> users = FXCollections.observableArrayList();
	
	public DataSource() {
		// Ajout de quelques utilisateur
		users.add(new User("Aw", "Cheikh", "aw.cheikh@gmail.com", "774443322", Role.SIMPLE_USER));
		users.add(new User("Ba", "Jules", "ba.jules@gmail.com", "773332929", Role.SIMPLE_USER));
		users.add(new User("Diallo", "Bouh", "diallo.bouh@gmail.com", "779995566", Role.SIMPLE_USER));
		users.add(new User("Dia", "Rmata", "dia.ramata@gmail.com", "776667788", Role.SIMPLE_USER));
		users.add(new User("Ba", "Saly", "ba.saly@gmail.com", "771834454", Role.SIMPLE_USER));
		users.add(new User("Faye", "Mamadou", "faye.mamadou@gmail.com", "779876545", Role.SIMPLE_USER));
		users.add(new User("Sow", "Aliou", "sow.aliou@gmail.com", "778887712", Role.SIMPLE_USER));
		users.add(new User("Diome", "Malick", "diome.malick@gmail.com", "775678765", Role.ADMINISTRATEUR));
		users.add(new User("Haida", "Ahmed", "haida.ahmed@gmail.com", "774271318", Role.ADMINISTRATEUR));
		users.add(new User("Ndir", "Khadim", "ndir.khadim@gmail.com", "771230987", Role.ADMINISTRATEUR));
	}
	
	public ObservableList<User> getUsers() {
		return users;
	}

}
