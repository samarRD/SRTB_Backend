package edu.projet.pfe.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@SuppressWarnings("serial")
@Entity
public class Lignes implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String libelle;
	private float kilometrage;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Arret arretdepart;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Arret arretarrivee;
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

	public float getKilometrage() {
		return kilometrage;
	}

	public void setKilometrage(float kilometrage) {
		this.kilometrage = kilometrage;
	}
	public Arret getArretdepart() {
		return arretdepart;
	}

	public void setArretdepart(Arret arretdepart) {
		this.arretdepart = arretdepart;
	}

	public Arret getArretarrivee() {
		return arretarrivee;
	}

	public void setArretarrivee(Arret arretarrivee) {
		this.arretarrivee = arretarrivee;
	}

}
