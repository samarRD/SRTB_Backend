package edu.projet.pfe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.projet.pfe.entities.Rapport1;
import edu.projet.pfe.entities.Rapport2;
import edu.projet.pfe.services.Rapport2Service;
import edu.projet.pfe.services.RapportService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/rapports2")
public class Rapport2Controller {
	@Autowired
	private Rapport2Service rs;

	// methode pour recuperer toutes les rapports d'un chauffeur par son id
	@GetMapping("/{vehiculeId}")
	public List<Rapport2> getRapportByVehiculeId(@PathVariable(value = "vehiculeId") Long vehiculeId) {

		return rs.findByVehiculeId(vehiculeId);
	}

	// methode pour recuperer un rapport d'un chauffeur par jour
	@GetMapping("/{vehiculeId}/{date}")
	public Rapport2 getVehiculeRapportByWeek(@PathVariable(value = "vehiculeId") Long Id,
			@PathVariable(value = "date") String date) {
		List<Rapport2> rapports = rs.findByVehiculeId(Id);
		if (rapports.isEmpty()) {
			return null;
		} else {
			for (Rapport2 rapport : rapports) {
				if (rapport.getPerformanceJour().equals(date)) {

					return rapport;
				}
			}
		}
		return null;
	}
	@GetMapping("/{vehiculeId}/{date1}/{date2}")
	public List<Rapport2> getVehiculeRapport(@PathVariable(value = "vehiculeId") Long Id,
			@PathVariable(value = "date1") String date1 ,@PathVariable(value = "date2") String date2) throws Throwable {
		return rs.getVehiculeRapport(Id, date1, date2);
	}


}
