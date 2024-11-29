package edu.projet.pfe.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.projet.pfe.entities.Rapport2;
import edu.projet.pfe.entities.Rapport3;
import edu.projet.pfe.entities.User;
import edu.projet.pfe.entities.Vehicule;
import edu.projet.pfe.entities.Versement;
import edu.projet.pfe.entities.Voyage;
import edu.projet.pfe.repositories.Rapport3Repository;
import edu.projet.pfe.repositories.ServiceRepository;
import edu.projet.pfe.repositories.UserRepository;

@Service
public class Rapport3ServiceImpl implements Rapport3Service {

	@Autowired
	private Rapport3Repository rr;
	@Autowired
	private UserRepository ur;
	@Autowired
	private ServiceRepository sr;
	@Autowired
	private VoyageService vs;

	@Override
	public List<Rapport3> findByUserId(Long id) {
		User user = ur.findById(id).get();
		return rr.findByUser(user);

	}

	public List<Rapport3> getUserRapport(Long Id, String date1, String date2) throws ParseException {
		// Définir le format de date souhaité
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		// Convertir les chaînes de caractères en objets Date
		Date startDate = dateFormat.parse(date1);
		Date endDate = dateFormat.parse(date2);

		// Rechercher les rapports entre les deux dates pour le véhicule spécifié
		User user = ur.findById(Id).get();
		List<Rapport3> rapports = rr.findByUser(user);
		List<Rapport3> rapportsBetweenDates = new ArrayList<>();
		if (!rapports.isEmpty()) {
			for (Rapport3 r : rapports) {
				Date rapportDate = dateFormat.parse(r.getDate());
				if (rapportDate.compareTo(startDate) >= 0 && rapportDate.compareTo(endDate) <= 0) {
					rapportsBetweenDates.add(r);
				}
			}
		}
		return rapportsBetweenDates;
	}

	@Override
	public Rapport3 getUserRapportByDay(Long Id, String date) {
		User user = ur.findById(Id).get();
		List<Rapport3> Rapports = rr.findByUser(user);
		if (Rapports.isEmpty()) {
			return null;
		} else {
			for (Rapport3 r : Rapports) {
				if (r.getDate().equals(date)) {

					return r;
				}
			}
		}

		return null;
	}

	@Override
	public Rapport3 createRapport(Voyage voyage) {
		User user = ur.findById(voyage.getUserrealise().getId()).get();
		Rapport3 R = new Rapport3();
		R.setUser(user);
		Calendar cal = Calendar.getInstance();
		cal.setTime(voyage.getDate());
		String date = String.valueOf(cal.get(Calendar.DATE)) + '-' + String.valueOf(cal.get(Calendar.MONTH) + 1) + '-'
				+ String.valueOf(cal.get(Calendar.YEAR));
		R.setDate(date);
		R.setRecette(voyage.getRecette());
		R.setKilometrage(voyage.getService().getLigne().getKilometrage());
		R.setService(voyage.getService().getLibelle());
		return rr.save(R);
	}

}
