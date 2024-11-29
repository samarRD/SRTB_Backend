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

import edu.projet.pfe.entities.Services;
import edu.projet.pfe.services.ServiceSRT;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/services")
public class ServiceController {
	@Autowired
	private ServiceSRT sr;

	@GetMapping
	public List<Services> getservices() {
		return sr.getAllServices();
	}

	@PostMapping
	public Services createServices(@RequestBody Services s) {
		return sr.createService(s);
	}
	@PostMapping(path = "/{id_ligne}")
	public Services create(@RequestBody Services s,@PathVariable Long id_ligne) {
		return sr.create(s,id_ligne);
	}
	@PutMapping(path = "/{id_ligne}")
	public Services Update(@RequestBody Services s,@PathVariable Long id_ligne) {
		return sr.update(s,id_ligne);
	}

	@PutMapping
	public Services updateService(@RequestBody Services s) {
		return sr.UpdateService(s);
	}

	@DeleteMapping(path = "/{id}")
	public void deleteSevice(@PathVariable Long id) {
		sr.DeleteService(id);
	}

	@GetMapping(path = "/{id}")
	public Services findServicebyid(@PathVariable Long id) {
		return sr.findServiceById(id);
	}



}
