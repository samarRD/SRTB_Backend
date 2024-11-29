package edu.projet.pfe.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Voyage implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private float recette;
	private String nbr_voyageur;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date date;
	@ManyToOne
	private Services service;
	@ManyToOne
	private User user;
	@ManyToOne
	private User userrealise;
	@ManyToOne
	private Vehicule vehiculerealise;
	@ManyToOne
	private Vehicule vehicule;



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public float getRecette() {
		return recette;
	}

	public void setRecette(float recette) {
		this.recette = recette;
	}

	public String getNbr_voyageur() {
		return nbr_voyageur;
	}

	public void setNbr_voyageur(String nbr_voyageur) {
		this.nbr_voyageur = nbr_voyageur;
	}

	public Services getService() {
		return service;
	}

	public void setService(Services service) {
		this.service = service;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Vehicule getVehicule() {
		return vehicule;
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}

	public User getUserrealise() {
		return userrealise;
	}

	public void setUserrealise(User userrealise) {
		this.userrealise = userrealise;
	}

	public Vehicule getVehiculerealise() {
		return vehiculerealise;
	}

	public void setVehiculerealise(Vehicule vehiculerealise) {
		this.vehiculerealise = vehiculerealise;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Voyage [id=" + id +  ", recette=" + recette + ", nbr_voyageur="
				+ nbr_voyageur + ", date=" + date + ", service=" + service + ", user=" + user + ", userrealise="
				+ userrealise + ", vehiculerealise=" + vehiculerealise + ", vehicule=" + vehicule + "]";
	}


	
	

}
