package sn.allit.core.entity;

public class Film {
	
	private String titre;
	private String genre;
	private Integer nbExemplaires;
	
	public Film() {}

	public String getTitre() { 
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Integer getNbExemplaires() {
		return nbExemplaires;
	}

	public void setNbExemplaires(Integer nbExemplaires) {
		this.nbExemplaires = nbExemplaires;
	}

}
