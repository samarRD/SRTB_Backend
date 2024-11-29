package edu.projet.pfe.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
@Entity
public class Rapport3 implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String date;
	private float recette;
	private String service ;
	private float kilometrage ;
	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	private User user;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public float getRecette() {
		return recette;
	}
	public void setRecette(float recette) {
		this.recette = recette;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public float getKilometrage() {
		return kilometrage;
	}
	public void setKilometrage(float kilometrage) {
		this.kilometrage = kilometrage;
	}

	
	
}
