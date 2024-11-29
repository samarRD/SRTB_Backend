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
import edu.projet.pfe.entities.Rapport2;
import edu.projet.pfe.entities.Versement;
import edu.projet.pfe.services.Rapport2Service;
import edu.projet.pfe.services.VersementService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/versements")
public class VersementController {
	@Autowired
	private VersementService vs;
	@Autowired
	private Rapport2Service rs;
	@GetMapping
	public List<Versement> getVersements() {
		return vs.getAllVersements();
	}

	@PostMapping(path="/{id_vehicule}")
	public Versement createVersement(@RequestBody Versement v,@PathVariable Long id_vehicule ) {
		Versement versement= vs.createVersement(v,id_vehicule);
		Calendar cal = Calendar.getInstance();
		cal.setTime(versement.getDate());
		String date = String.valueOf(cal.get(Calendar.DATE)) + '-' + String.valueOf(cal.get(Calendar.MONTH) + 1) + '-'
				+ String.valueOf(cal.get(Calendar.YEAR));

		//Rapport2 r = rs.getVehiculeRapportByDay(id_vehicule, date);
			Rapport2 pn = rs.createRapport(versement);
		
		return versement ;
	}

	@PutMapping
	public Versement updateVersement(@RequestBody Versement v) {
		return vs.UpdateVersement(v);
	}

	@DeleteMapping(path = "/{i}")
	public void deleteVersement(@PathVariable Long i) {
		vs.DeleteVersement(i);
	}


	@GetMapping(path = "/{i}")
	public Versement findVersementbyid(@PathVariable Long i) {
		return vs.findVersementById(i);
	}

}
