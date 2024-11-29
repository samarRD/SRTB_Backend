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


import edu.projet.pfe.entities.Type;

import edu.projet.pfe.services.TypeService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/types")
public class TypeController {
	@Autowired
	private TypeService tr;
	
	@GetMapping
	public List<Type> getTypes() {
		return tr.getAllTypes();
	}

	@PostMapping
	public Type createType(@RequestBody Type t) {
		return tr.createType(t);
	}

	@PutMapping
	public Type updateType(@RequestBody Type t) {
		return tr.UpdateType(t);
	}

	@DeleteMapping(path = "/{i}")
	public void deleteType(@PathVariable Long i) {
		tr.DeleteType(i);
	}


	@GetMapping(path = "/{i}")
	public Type findTypebyid(@PathVariable Long i) {
		return tr.findTypeById(i);
	}
	

}
