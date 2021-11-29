package com.ums;

import com.ums.model.User;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DataSource {
	
	private ObservableList<User> users = FXCollections.observableArrayList();
	
	public DataSource() {
		
		// Ajoutons quelques utilisateurs
		users.add(new User("Gosling", "James", "jamesgosling@gmail.com", "777777788"));
		users.add(new User("Stroustrup", "Bjarne", "stroustrupbjarne@gmail.com", "777777788"));
		users.add(new User("Ritchie", "Dennis", "ritchiedennis@gmail.com", "777777788"));
		users.add(new User("Thompson", "Kenneth", "thompsonkenneth@gmail.com", "777777788"));
		users.add(new User("Rossum", "Guido Van", "rossumguidovan@gmail.com", "777777788"));
		users.add(new User("Lerdorf", "Rasmus", "rasmuslerdorf@gmail.com", "777777788"));
		users.add(new User("Lerdorf", "Rasmus", "rasmuslerdorf@gmail.com", "777777788"));
		users.add(new User("Lerdorf", "Rasmus", "rasmuslerdorf@gmail.com", "777777788"));
		users.add(new User("Lerdorf", "Rasmus", "rasmuslerdorf@gmail.com", "777777788"));
		users.add(new User("Lerdorf", "Rasmus", "rasmuslerdorf@gmail.com", "777777788"));
	}
	
	public ObservableList<User> getUsers() {
		return users;
	}

}
