package edu.projet.pfe.controller;

import java.lang.reflect.Type;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.projet.pfe.entities.Rapport1;
import edu.projet.pfe.services.RapportService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/rapports")
public class RapportController {
	@Autowired
	private RapportService rs;

	// methode pour recuperer toutes les rapports d'un chauffeur par son id
	@GetMapping("/{userId}")
	public List<Rapport1> getRapportByUserId(@PathVariable(value = "userId") Long userId) {

		return rs.findByUserId(userId);
	}

	// methode pour recuperer un rapport d'un chauffeur par jour
	@GetMapping("/{userId}/{date}")
	public Rapport1 getUserRapportByWeek(@PathVariable(value = "userId") Long Id,
			@PathVariable(value = "date") String date) {
		List<Rapport1> rapports = rs.findByUserId(Id);
		if (rapports.isEmpty()) {
			return null;
		} else {
			for (Rapport1 rapport : rapports) {
				if (rapport.getPerformanceJour().equals(date)) {

					return rapport;
				}
			}
		}
		return null;
	}

}
