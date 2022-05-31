package sn.boom.javaws.entities;

public class Subscriber {
	
	private Integer id;
	private String nom;
	private String numero;
	private String adresse;
	private Boolean activated;
	
	public Subscriber() {
		this(-1, "none", "none", "none", false);
	}
	
	public Subscriber(String nom, String numero, String adresse) {
		this.nom = nom;
		this.numero = numero;
		this.adresse = adresse;
		setActivated(false);
	}
	
	public Subscriber(Integer id, String nom, String numero, String adresse, Boolean activated) {
		this(nom, numero, adresse);
		
		setId(id);
		setActivated(activated);
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public Boolean getActivated() {
		return activated;
	}
	public void setActivated(Boolean activated) {
		this.activated = activated;
	}

}
