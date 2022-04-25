package sn.allit.core.controller;

import java.util.Scanner;

import sn.allit.core.entity.Film;
import sn.allit.core.service.FilmService;

public class DefaultFilmController {

	public void registerFilmFromconsoleInput() {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Entrer le titre :");
		String titre = scan.nextLine();
		System.out.println("Entrer le genre :");
		String genre = scan.nextLine();
		System.out.println("Entrer le nombre d'exemplaire : ");
		Integer nb = Integer.parseInt(scan.nextLine());
		
		Film film = new Film();
		film.setTitre(titre);
		film.setTitre(genre);
		film.setNbExemplaires(nb);
		
		FilmService films = new FilmService();
		films.registerFilm(film);
		
		
	}
}
