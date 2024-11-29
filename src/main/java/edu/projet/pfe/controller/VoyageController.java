package edu.projet.pfe.controller;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.projet.pfe.entities.Rapport1;
import edu.projet.pfe.entities.Rapport3;
import edu.projet.pfe.entities.Services;
import edu.projet.pfe.entities.Voyage;
import edu.projet.pfe.repositories.RapportRepository;
import edu.projet.pfe.repositories.ServiceRepository;
import edu.projet.pfe.repositories.VoyageRepository;
import edu.projet.pfe.services.Rapport3Service;
import edu.projet.pfe.services.RapportService;
import edu.projet.pfe.services.VoyageService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/voyages")
public class VoyageController {
	@Autowired
	private VoyageService vs;
	@Autowired
	private ServiceRepository s;
	@Autowired
	private VoyageRepository v;
	@Autowired
	private RapportService rapport;
	@Autowired
	private Rapport3Service rapport3;

	@GetMapping
	public List<Voyage> getVoyages() {
		return vs.getAllVoyages();
	}

	@PutMapping
	public Voyage update(@RequestBody Voyage v) {
		Voyage voyage = vs.UpdateVoyage(v);
		Calendar cal = Calendar.getInstance();
		cal.setTime(v.getDate());
		String date = String.valueOf(cal.get(Calendar.DATE)) + '-' + String.valueOf(cal.get(Calendar.MONTH) + 1) + '-'
				+ String.valueOf(cal.get(Calendar.YEAR));

		// Rapport3 r = rapport3.getUserRapportByDay(voyage.getUserrealise().getId(),
		// date);
		Rapport3 pn = rapport3.createRapport(voyage);

		return voyage;
	}

	@DeleteMapping(path = "/{i}")
	public void deleteVoyage(@PathVariable Long i) {
		vs.DeleteVoyage(i);
	}

	@GetMapping(path = "/{i}")
	public Voyage findVoyagebyid(@PathVariable Long i) {
		return vs.findVoyageById(i);
	}

	@PostMapping("/addV/{id_user}/{id_service}/{id_vehicule}")
	public Voyage createVoyageServicesUser(@PathVariable Long id_user, @PathVariable Long id_service,
			@PathVariable Long id_vehicule, @RequestBody Voyage v) {
		Voyage voyage = vs.createVoyageServiceUser(v, id_user, id_service, id_vehicule);

		return voyage;
	}

	@PutMapping("/UpdateV/{id_userrealise}/{id_vehiculerealise}")
	public Voyage updateVoyageServicesUser(@PathVariable Long id_userrealise, @PathVariable Long id_vehiculerealise,
			@RequestBody Voyage v) {

		Voyage voyage = vs.updateVoyageServiceUser(v, id_userrealise, id_vehiculerealise);

		Calendar cal = Calendar.getInstance();
		cal.setTime(voyage.getDate());
		String date = String.valueOf(cal.get(Calendar.DATE)) + '-' + String.valueOf(cal.get(Calendar.MONTH) + 1) + '-'
				+ String.valueOf(cal.get(Calendar.YEAR));

		Rapport1 r = rapport.getUserRapportByDay(id_userrealise, date);

		if (r != null) {
			Rapport1 pn = rapport.updateRapport(r.getId(), voyage);
		} else {
			Rapport1 pn = rapport.createRapport(voyage);
		}
		return voyage;

	}

}
