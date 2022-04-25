package sn.allit.core.service;

import sn.allit.core.entity.Film;
import sn.allit.core.repository.FileFilmRepository;

public class FilmService {

	public void registerFilm(Film f) {
		
		FileFilmRepository filmRepo = new FileFilmRepository();
		filmRepo.save(f);
		
	}
}
