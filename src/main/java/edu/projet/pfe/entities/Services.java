package edu.projet.pfe.entities;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Services implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String libelle;
	private LocalTime heure_depart;
	private LocalTime heure_arrive;
	@ManyToOne
	private Lignes ligne;
	

	public Services() {
		super();
	}

	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
		
	public LocalTime getHeure_depart() {
		return heure_depart;
	}

	public void setHeure_depart(LocalTime heure_depart) {
		this.heure_depart = heure_depart;
	}

	public LocalTime getHeure_arrive() {
		return heure_arrive;
	}

	public void setHeure_arrive(LocalTime heure_arrive) {
		this.heure_arrive = heure_arrive;
	}

	public Lignes getLigne() {
		return ligne;
	}

	public void setLigne(Lignes ligne) {
		this.ligne = ligne;
	}

	@Override
	public String toString() {
		return "Services [id=" + id + ", libelle=" + libelle + ", heure_depart="
				+ heure_depart + ", heure_arrive=" + heure_arrive + ", ligne=" + ligne + "]";
	}
	

}
