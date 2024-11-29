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
import edu.projet.pfe.entities.Vehicule;
import edu.projet.pfe.services.VehiculeService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/vehicules")
public class VehiculeController {

	@Autowired
	private VehiculeService vr;
	
	@GetMapping
	public List<Vehicule> getVehicules() {
		return vr.getAllVehicules();
	}

	@PostMapping
	public Vehicule createVehicule(@RequestBody Vehicule v) {
		return vr.createVehicule(v);
	}

	@PutMapping
	public Vehicule updateVehicule(@RequestBody Vehicule v) {
		return vr.UpdateVehicule(v);
	}

	@DeleteMapping(path = "/{i}")
	public void deleteVehicule(@PathVariable Long i) {
		vr.DeleteVehicule(i);
	}


	@GetMapping(path = "/{i}")
	public Vehicule findVehiculebyid(@PathVariable Long i) {
		return vr.findVehiculeById(i);
	}
	
	@PostMapping("/addTypeMarque/{id_type}/{id_marque}")
	public Vehicule  createTypeMarqueVehicule(@PathVariable Long id_type,@PathVariable Long id_marque,@RequestBody Vehicule v) {
		return vr.createTypeMarqueVehicule(v,id_type,id_marque);
	}
	
	@PutMapping("/updateTypeMarque/{id_type}/{id_marque}")
	public Vehicule  updateTypeMarqueVehicule(@PathVariable Long id_type,@PathVariable Long id_marque,@RequestBody Vehicule v) {
		return vr.updateTypeMarqueVehicule(v,id_type,id_marque);
	}
}
