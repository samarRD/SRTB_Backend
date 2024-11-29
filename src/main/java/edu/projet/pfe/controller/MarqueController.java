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

import edu.projet.pfe.entities.Marque;
import edu.projet.pfe.services.MarqueService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/marques")
public class MarqueController {
	@Autowired
	private MarqueService mr;
	
	@GetMapping
	public List<Marque> getMarques() {
		return mr.getAllMarques();
	}

	@PostMapping
	public Marque createMarque(@RequestBody Marque m) {
		return mr.createMarque(m);
	}

	@PutMapping
	public Marque updateMarque(@RequestBody Marque m) {
		return mr.UpdateMarque(m);
	}

	@DeleteMapping(path = "/{i}")
	public void deleteMarque(@PathVariable Long i) {
		mr.DeleteMarque(i);
	}


	@GetMapping(path = "/{i}")
	public Marque findMarquebyid(@PathVariable Long i) {
		return mr.findMarqueById(i);
	}

}
