package edu.projet.pfe.services;

import java.util.List;

import edu.projet.pfe.entities.Rapport1;
import edu.projet.pfe.entities.Rapport2;
import edu.projet.pfe.entities.Versement;

public interface Rapport2Service {

	public List<Rapport2> findByVehiculeId(Long id);

	public Rapport2 getVehiculeRapportByDay(Long Id, String date);

	public Rapport2 createRapport(Versement versement);

	public List<Rapport2> getVehiculeRapport(Long Id, String date1, String date2) throws Throwable;

}
