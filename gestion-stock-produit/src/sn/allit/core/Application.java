package sn.allit.core;


import sn.allit.core.controller.DefaultFilmController;


public class Application {

	public static void main(String[] args) {
		
		DefaultFilmController defaultFilm = new DefaultFilmController();
		defaultFilm.registerFilmFromconsoleInput();
	}
}
