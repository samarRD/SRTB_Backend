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
public class Rapport2 implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private float kilometrage;
	private float consommation_carburant;
	private float taux_consommation;
	private String performanceJour;
	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Vehicule vehicule;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public float getKilometrage() {
		return kilometrage;
	}
	public void setKilometrage(float kilometrage) {
		this.kilometrage = kilometrage;
	}
	public float getConsommation_carburant() {
		return consommation_carburant;
	}
	public void setConsommation_carburant(float consommation_carburant) {
		this.consommation_carburant = consommation_carburant;
	}
	public float getTaux_consommation() {
		return taux_consommation;
	}
	public void setTaux_consommation(float taux_consommation) {
		this.taux_consommation = taux_consommation;
	}
	public String getPerformanceJour() {
		return performanceJour;
	}
	public void setPerformanceJour(String performanceJour) {
		this.performanceJour = performanceJour;
	}
	public Vehicule getVehicule() {
		return vehicule;
	}
	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}
	

}
