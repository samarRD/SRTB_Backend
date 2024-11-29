package edu.projet.pfe.services;

import java.util.List;

import edu.projet.pfe.entities.Arret;


public interface ArretService {
	public Arret   createArret  (Arret   a);
	public List<Arret  > getAllArrets();
	public Arret findArretById(Long id);
	public Arret  UpdateArret(Arret a);
	public void DeleteArret(Long id);

}
