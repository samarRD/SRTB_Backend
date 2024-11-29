package edu.projet.pfe.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Vehicule implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String matricule;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date datemise_enmarche;
	private String taux_consommation;
	private Boolean status;
	private String description;

	@ManyToOne(cascade = CascadeType.REMOVE)
	private Type type;
	@ManyToOne
	private Marque marque;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public Date getDatemise_enmarche() {
		return datemise_enmarche;
	}

	public void setDatemise_enmarche(Date datemise_enmarche) {
		this.datemise_enmarche = datemise_enmarche;
	}

	public String getTaux_consommation() {
		return taux_consommation;
	}

	public void setTaux_consommation(String taux_consommation) {
		this.taux_consommation = taux_consommation;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Marque getMarque() {
		return marque;
	}

	public void setMarque(Marque marque) {
		this.marque = marque;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Vehicule [id=" + id + ", matricule=" + matricule + ", datemise_enmarche=" + datemise_enmarche
				+ ", taux_consommation=" + taux_consommation + ", status=" + status + ", description=" + description
				+ ", type=" + type + ", marque=" + marque + "]";
	}

}
