package edu.projet.pfe.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Versement {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private float quantite_gasoil;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date date;
	private float kilometrage_compteur;
	@ManyToOne
	private Vehicule vehicule;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Vehicule getVehicule() {
		return vehicule;
	}
	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}
	public float getQuantite_gasoil() {
		return quantite_gasoil;
	}
	public void setQuantite_gasoil(float quantite_gasoil) {
		this.quantite_gasoil = quantite_gasoil;
	}
	public float getKilometrage_compteur() {
		return kilometrage_compteur;
	}
	public void setKilometrage_compteur(float kilometrage_compteur) {
		this.kilometrage_compteur = kilometrage_compteur;
	}
	
	
}
