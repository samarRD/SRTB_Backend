package edu.projet.pfe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.projet.pfe.entities.Rapport2;
import edu.projet.pfe.entities.Rapport3;
import edu.projet.pfe.services.Rapport3Service;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/rapports3")
public class Rapport3Controller {
	@Autowired
	private Rapport3Service rs;

	// methode pour recuperer toutes les rapports d'un chauffeur par son id
	@GetMapping("/{userId}")
	public List<Rapport3> getRapportByUserId(@PathVariable(value = "userId") Long userId) {

		return rs.findByUserId(userId);
	}
	@GetMapping("/{userId}/{date}")
	public Rapport3 getUserRapportByDay(@PathVariable(value = "userId") Long Id,
			@PathVariable(value = "date") String date) {
		List<Rapport3> rapports = rs.findByUserId(Id);
		if (rapports.isEmpty()) {
			return null;
		} else {
			for (Rapport3 rapport : rapports) {
				if (rapport.getDate().equals(date)) {

					return rapport;
				}
			}
		}
		return null;
		}
	
	@GetMapping("/{userId}/{date1}/{date2}")
	public List<Rapport3> getUserRapport(@PathVariable(value = "userId") Long Id,
			@PathVariable(value = "date1") String date1 ,@PathVariable(value = "date2") String date2) throws Throwable {
		return rs.getUserRapport(Id, date1, date2);
	}

}
