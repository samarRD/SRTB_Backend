package edu.projet.pfe.services;

import java.text.ParseException;
import java.util.List;


import edu.projet.pfe.entities.Rapport3;
import edu.projet.pfe.entities.Voyage;

public interface Rapport3Service {

	public List<Rapport3> findByUserId(Long id);
	public List<Rapport3> getUserRapport(Long Id, String date1, String date2) throws ParseException;
	public Rapport3 createRapport(Voyage voyage);
	public Rapport3 getUserRapportByDay(Long Id, String date);
}
