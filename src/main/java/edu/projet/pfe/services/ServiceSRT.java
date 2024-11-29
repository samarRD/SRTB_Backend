package edu.projet.pfe.services;

import java.util.List;

import edu.projet.pfe.entities.Lignes;
import edu.projet.pfe.entities.Services;

public interface ServiceSRT {
	public Services createService(Services s);
	public List<Services> getAllServices();
	public Services findServiceById(Long id);
	public Services UpdateService(Services s);
	public void DeleteService(Long id);
	public Services update(Services s,Long id_ligne);
	public Services create(Services s, Long id_ligne);
	
	
	
}
