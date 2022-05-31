package com.javaws.entities;

public class Subscriber {
	private int id;
	private String nom;
	private String numero;	
	private String adresse;
	private boolean activated;
	
	public Subscriber(int id, String nom, String numero, String adresse, boolean activated) {
		this (nom, numero, adresse);
		this.setId(id);
		this.setActivated(activated);
	}
	
	public Subscriber(String nom, String numero, String adresse) {
		this.nom = nom;
		this.numero = numero;
		this.adresse = adresse;
	}
	
	public String getAdresse() {
		return adresse;
	}
	
	public int getId() {
		return id;
	}
	
	public String getNom() {
		return nom;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public void setActivated(boolean activated) {
		this.activated = activated;
	}
	
	public boolean isActivated() {
		return activated;
	}
	
	public void setId(int id) {
		if (id > 0)
			this.id = id;
	}
}
