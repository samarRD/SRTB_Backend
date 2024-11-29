package edu.projet.pfe.services;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.projet.pfe.entities.Rapport1;
import edu.projet.pfe.entities.Services;
import edu.projet.pfe.entities.User;
import edu.projet.pfe.entities.Voyage;
import edu.projet.pfe.repositories.RapportRepository;
import edu.projet.pfe.repositories.ServiceRepository;
import edu.projet.pfe.repositories.UserRepository;

@Service
public class RapportServicelmpl implements RapportService {
	@Autowired
	private RapportRepository rapport;
	@Autowired
	private UserRepository ur;
	@Autowired
	ServiceRepository sr;

	@Override
	public List<Rapport1> findByUserId(Long id) {
		User user = ur.findById(id).get();
		return rapport.findByUser(user);

	}

	@Override
	public Rapport1 createRapport(Voyage voyage) {

		User user = ur.findById(voyage.getUserrealise().getId()).get();
		Rapport1 R = new Rapport1();
		R.setUser(user);
		Calendar cal = Calendar.getInstance();
		cal.setTime(voyage.getDate());
		String date = String.valueOf(cal.get(Calendar.DATE)) + '-' + String.valueOf(cal.get(Calendar.MONTH) + 1) + '-'
				+ String.valueOf(cal.get(Calendar.YEAR));
		R.setPerformanceJour(date);
		Services s = voyage.getService();

		Duration duration = Duration.between(s.getHeure_depart(), s.getHeure_arrive()).multipliedBy(2);
		long minutes = duration.toMinutes();
		long hours = minutes / 60;
		long remainingMinutes = minutes % 60;
		float t = (float) (hours + ((float) remainingMinutes) * 0.01);
		R.setNbrHH(t);
		R.setHeure(hours + " h et " + remainingMinutes + " min");
		return rapport.save(R);
	}

	@Override
	public Rapport1 getRapportById(Long Id) {
		Optional<Rapport1> opt = rapport.findById(Id);

		if (opt.isEmpty())
			return null;
		else
			return opt.get();
	}

	// retourne le rapport d'un chauffeur à un date donné
	@Override
	public Rapport1 getUserRapportByDay(Long Id, String date) {
		User user = ur.findById(Id).get();
		List<Rapport1> Rapports = rapport.findByUser(user);
		if (Rapports.isEmpty()) {
			return null;
		} else {
			for (Rapport1 r : Rapports) {
				if (r.getPerformanceJour().equals(date)) {

					return r;
				}
			}
		}

		return null;
	}

	@Override
	public Rapport1 updateRapport(Long id, Voyage voyage) {
		float nbrTh = 0;
		Rapport1 r = rapport.findById(id).get();
		Services s = voyage.getService();
		Duration duration = Duration.between(s.getHeure_depart(), s.getHeure_arrive()).multipliedBy(2);
		long minutes = duration.toMinutes();
		long hours = minutes / 60;
		long remainingMinutes = minutes % 60;
		float t = (float) (hours + ((float) remainingMinutes) * 0.01);
		nbrTh = t + r.getNbrHH();

		Locale locale = new Locale("fr", "FR"); // specify a particular language and region to use for formatting date.
		String formatted = String.format(locale, "%.2f", nbrTh);
		String[] parts = formatted.split(",");
		int hour = Integer.parseInt(parts[0]);
		int min = Integer.parseInt(parts[1]);

		if (min == 60) {
			hour = hour + 1;
			min = 0;
		} else if (min > 60) {
			hour = hour + 1;
			min = min - 60;
		}

		float combined = (float) hour + ((float) min / 100);
		r.setHeure(hour + " h et " + min + " min");
		r.setNbrHH(combined);
		return rapport.save(r);
	}
}
