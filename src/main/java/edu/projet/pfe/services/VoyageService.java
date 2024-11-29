package edu.projet.pfe.services;

import java.util.List;

import edu.projet.pfe.entities.Services;
import edu.projet.pfe.entities.Voyage;

public interface VoyageService {
	public Voyage createVoyage(Voyage v);

	public List<Voyage> getAllVoyages();

	public Voyage findVoyageById(Long id);

	public Voyage UpdateVoyage(Voyage v);

	public void DeleteVoyage(Long id);

	public Voyage createVoyageServiceUser(Voyage v, Long user_id, Long service_id, Long vehicule_id);

	public Voyage updateVoyageServiceUser(Voyage v, Long userrealise_id, Long vehiculerealise_id);
	
	
}
