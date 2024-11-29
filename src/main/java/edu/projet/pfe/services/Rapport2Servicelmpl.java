package edu.projet.pfe.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.projet.pfe.entities.Rapport1;
import edu.projet.pfe.entities.Rapport2;
import edu.projet.pfe.entities.Services;
import edu.projet.pfe.entities.User;
import edu.projet.pfe.entities.Vehicule;
import edu.projet.pfe.entities.Versement;
import edu.projet.pfe.entities.Voyage;
import edu.projet.pfe.repositories.Rapport2Repository;
import edu.projet.pfe.repositories.VehiculeRepository;
import edu.projet.pfe.repositories.VoyageRepository;

@Service
public class Rapport2Servicelmpl implements Rapport2Service {
	@Autowired
	VehiculeRepository vr;
	@Autowired
	Rapport2Repository rr;
	@Autowired
	VoyageService vs;

	@Override
	public List<Rapport2> findByVehiculeId(Long id) {
		Vehicule vehicule = vr.findById(id).get();
		return rr.findByVehicule(vehicule);

	}

	@Override
	public Rapport2 getVehiculeRapportByDay(Long Id, String date) {
		Vehicule vehicule = vr.findById(Id).get();
		List<Rapport2> Rapports = rr.findByVehicule(vehicule);
		if (Rapports.isEmpty()) {
			return null;
		} else {
			for (Rapport2 r : Rapports) {
				if (r.getPerformanceJour().equals(date)) {

					return r;
				}
			}
		}

		return null;
	}

	public List<Rapport2> getVehiculeRapport(Long Id, String date1, String date2) throws ParseException {
		// Définir le format de date souhaité
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		// Convertir les chaînes de caractères en objets Date
		Date startDate = dateFormat.parse(date1);
		Date endDate = dateFormat.parse(date2);

		// Rechercher les rapports entre les deux dates pour le véhicule spécifié
		Vehicule vehicule = vr.findById(Id).get();
		List<Rapport2> rapports = rr.findByVehicule(vehicule);
		List<Rapport2> rapportsBetweenDates = new ArrayList<>();
		if (!rapports.isEmpty()) {
			for (Rapport2 r : rapports) {
				Date rapportDate = dateFormat.parse(r.getPerformanceJour());
				if (rapportDate.compareTo(startDate) >= 0 && rapportDate.compareTo(endDate) <= 0) {
					rapportsBetweenDates.add(r);
				}
			}
		}
		return rapportsBetweenDates;
	}

	@Override
	public Rapport2 createRapport(Versement versement) {
		float totalKilometrage = 0;
		List<Voyage> voyages = vs.getAllVoyages();

		Vehicule v = vr.findById(versement.getVehicule().getId()).get();

		Rapport2 R = new Rapport2();
		R.setVehicule(v);
		Calendar cal = Calendar.getInstance();
		cal.setTime(versement.getDate());
		String date = String.valueOf(cal.get(Calendar.DATE)) + '-' + String.valueOf(cal.get(Calendar.MONTH) + 1) + '-'
				+ String.valueOf(cal.get(Calendar.YEAR));
		R.setPerformanceJour(date);
		for (Voyage voyage : voyages) {
			if (v.getMatricule() == voyage.getVehiculerealise().getMatricule()
					&& versement.getDate().equals(voyage.getDate())) {

				float k = voyage.getService().getLigne().getKilometrage() * 2;
				totalKilometrage += k;
				System.out.println(totalKilometrage);
				float q = versement.getQuantite_gasoil();
				float taux = (q / totalKilometrage) * 100;
				R.setConsommation_carburant(q);
				R.setKilometrage(totalKilometrage);
				R.setTaux_consommation(taux);

			}
		}

		return rr.save(R);
	}

}
