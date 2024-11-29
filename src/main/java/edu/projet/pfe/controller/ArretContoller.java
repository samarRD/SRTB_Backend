package edu.projet.pfe.controller;

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

import edu.projet.pfe.entities.Arret;
import edu.projet.pfe.entities.Lignes;
import edu.projet.pfe.services.ArretService;
import edu.projet.pfe.services.LigneService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/arrets")
public class ArretContoller {
	@Autowired
	private ArretService as;
	
	@GetMapping
	public List<Arret> getArret() {
		return as.getAllArrets();
	}

	@PostMapping
	public Arret createArret(@RequestBody Arret a) {
		return as.createArret(a);
	}

	@PutMapping
	public Arret updateArret(@RequestBody Arret a) {
		return as.UpdateArret(a);
	}

	@DeleteMapping(path = "/{i}")
	public void deleteArret(@PathVariable Long i) {
		as.DeleteArret(i);
	}


	@GetMapping(path = "/{i}")
	public Arret findArretbyid(@PathVariable Long i) {
		return as.findArretById(i);
	}

}
