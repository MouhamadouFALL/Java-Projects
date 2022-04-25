package sn.allit.core.repository;

import java.io.FileWriter;

import sn.allit.core.entity.Film;

public class FileFilmRepository {
	
	public void save(Film film) {
		
		FileWriter writer;
		try {
			writer = new FileWriter("C:\\Users\\nabyFall\\Desktop\\Films.txt", true);
			writer.write(film.getTitre()+ ";" + film.getGenre() + ";" + film.getNbExemplaires() + "\n");
			writer.close();
			
			System.out.println("Film bien enregistrer !");
			
		}
		catch(Exception e) {
			System.err.println("ERROR : " + e.getClass() + " : " + e.getMessage());
		}
		
	}
}
