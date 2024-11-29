package edu.projet.pfe.services;

import java.util.List;

import edu.projet.pfe.entities.Lignes;
import edu.projet.pfe.entities.Services;

public interface LigneService {
	
	public Lignes createLigne(Lignes l, Long id_arretdepart, Long id_arretarrivee);
	public Lignes update(Lignes l, Long id_arretdepart, Long id_arretarrivee);
	public List<Lignes> getAllLignes();
	public Lignes  findLigneById(Long id);
	public Lignes  UpdateLigne(Lignes l);
	public void DeleteLigne(Long id);
	
}
