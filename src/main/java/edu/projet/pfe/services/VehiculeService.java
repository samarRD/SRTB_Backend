package edu.projet.pfe.services;

import java.util.List;


import edu.projet.pfe.entities.Vehicule;

public interface VehiculeService {

	public Vehicule   createVehicule(Vehicule v);
	public List<Vehicule > getAllVehicules ();
	public Vehicule   findVehiculeById(Long id);
	public Vehicule   UpdateVehicule (Vehicule  v);
	public void DeleteVehicule (Long id);
	/*public Vehicule updatevehiculeUser(Vehicule v ,Long id);
	public Vehicule addvehiculeUser(Vehicule v, Long id);*/
	
	public Vehicule createTypeMarqueVehicule(Vehicule v, Long id_type, Long id_marque);
	 public Vehicule updateTypeMarqueVehicule(Vehicule v, Long id_type, Long id_marque);
}
