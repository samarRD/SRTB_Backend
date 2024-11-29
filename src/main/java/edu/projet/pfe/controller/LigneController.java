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

import edu.projet.pfe.entities.Lignes;
import edu.projet.pfe.entities.Services;
import edu.projet.pfe.services.LigneService;
import edu.projet.pfe.services.ServiceSRT;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/lignes")
public class LigneController {
	@Autowired
	private LigneService lr;
	
	@GetMapping
	public List<Lignes> getlignes() {
		return lr.getAllLignes();
	}

	@PostMapping(path="/{id_arretdepart}/{id_arretarrive}")
	public Lignes createlignes(@RequestBody Lignes l,@PathVariable Long id_arretdepart,@PathVariable Long id_arretarrive) {
		return lr.createLigne(l, id_arretdepart, id_arretarrive);
	}

	@PutMapping(path="/{id_arretdepart}/{id_arretarrive}")
	public Lignes updatelignes(@RequestBody Lignes l,@PathVariable Long id_arretdepart,@PathVariable Long id_arretarrive) {
		return lr.update(l, id_arretdepart, id_arretarrive);
	}

	@DeleteMapping(path = "/{i}")
	public void deletelignes(@PathVariable Long i) {
		lr.DeleteLigne(i);
	}


	@GetMapping(path = "/{i}")
	public Lignes findLignesbyid(@PathVariable Long i) {
		return lr.findLigneById(i);
	}

}
