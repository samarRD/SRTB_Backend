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
public class Rapport1 implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private float nbrHH;
	private String performanceJour;
	private String heure;
	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public float getNbrHH() {
		return nbrHH;
	}

	public void setNbrHH(float nbrHH) {
		this.nbrHH = nbrHH;
	}

	public String getPerformanceJour() {
		return performanceJour;
	}

	public void setPerformanceJour(String performanceJour) {
		this.performanceJour = performanceJour;
	}

	public String getHeure() {
		return heure;
	}

	public void setHeure(String heure) {
		this.heure = heure;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}
}
