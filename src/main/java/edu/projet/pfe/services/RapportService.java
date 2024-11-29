package edu.projet.pfe.services;

import java.util.List;

import edu.projet.pfe.entities.Rapport1;

import edu.projet.pfe.entities.Voyage;

public interface RapportService {

	public List<Rapport1> findByUserId(Long id);

	public Rapport1 createRapport(Voyage voyage);

	public Rapport1 getRapportById(Long Id);

	public Rapport1 getUserRapportByDay(Long Id, String date);

	public Rapport1 updateRapport(Long id, Voyage voyage);

}
