package edu.projet.pfe.services;

import java.util.List;


import edu.projet.pfe.entities.Marque;

public interface MarqueService {
	public Marque  createMarque(Marque m);
	public List<Marque> getAllMarques();
	public Marque  findMarqueById(Long id);
	public Marque  UpdateMarque(Marque m);
	public void DeleteMarque(Long id);

}
