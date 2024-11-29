package edu.projet.pfe.services;

import java.util.List;

import edu.projet.pfe.entities.Versement;

public interface VersementService {


	public List<Versement> getAllVersements();

	public Versement findVersementById(Long id);

	public Versement UpdateVersement(Versement v);

	public void DeleteVersement(Long id);

	public Versement createVersement(Versement v, long id);

}
