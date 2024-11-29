package edu.projet.pfe.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import edu.projet.pfe.config.JwtTokenUtil;
import edu.projet.pfe.domain.JwtResponse;
import edu.projet.pfe.domain.Message;
import edu.projet.pfe.entities.User;
import edu.projet.pfe.exception.ResourceNotFoundException;
import edu.projet.pfe.repositories.UserRepository;
import edu.projet.pfe.request.LoginRequest;
import edu.projet.pfe.request.RegisterRequest;
import edu.projet.pfe.services.UserDetailsImpl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	UserRepository repository;
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	JwtTokenUtil jwtUtils;

	@GetMapping
	public List<User> getAllUtilisateur() {
		List<User> Utilisateur = new ArrayList<>();
		repository.findAll().forEach(Utilisateur::add);

		return Utilisateur;
	}

	@GetMapping("/{UtilisateurId}")
	public ResponseEntity<User> getUtilisateurById(@PathVariable Long UtilisateurId)
			throws ResourceNotFoundException {
		User Utilisateur = repository.findById(UtilisateurId).orElseThrow(
				() -> new ResourceNotFoundException("Utilisateur not found for this id :: " + UtilisateurId));
		return ResponseEntity.ok().body(Utilisateur);
	}

	@DeleteMapping("/{id}")
	public Map<String, Boolean> deleteUtilisateur(@PathVariable(value = "id") Long UtilisateurId)
			throws ResourceNotFoundException {
		User Utilisateur = repository.findById(UtilisateurId)
				.orElseThrow(() -> new ResourceNotFoundException("Utilisateur not found  id :: " + UtilisateurId));

		repository.delete(Utilisateur);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteAllUtilisateur() {
		System.out.println("Delete All Utilisateur...");

		repository.deleteAll();

		return new ResponseEntity<>("All Utilisateurs have been deleted!", HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<User> updateUtilisateur(@RequestBody User Utilisateur) {

		Optional<User> UtilisateurInfo = repository.findById(Utilisateur.getId());

		if (UtilisateurInfo.isPresent()) {
			User utilisateur = UtilisateurInfo.get();
			utilisateur.setRole(Utilisateur.getRole());
			utilisateur.setEmail(Utilisateur.getEmail());
			utilisateur.setUsername(Utilisateur.getUsername());
			String password = Utilisateur.getPassword();
			if (password != null && !password.isEmpty()) {
			    String encodedPassword = encoder.encode(password);
			    Utilisateur.setPassword(encodedPassword);}
			return new ResponseEntity<>(repository.save(Utilisateur), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/update")
	public User update(@RequestBody User Utilisateur) {

		Optional <User> utOptional =repository.findById(Utilisateur.getId());
					
			if (utOptional.isEmpty()) {
					return null;
			}else {
			return repository.save(Utilisateur);
					}
	}

	@PostMapping("/login")
	public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest data) {
		// System.out.println(data.getPassword());
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(data.getEmail(), data.getPassword())

				);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
	
		
			return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(),
				userDetails.getEmail(), userDetails.getRole() ,userDetails.isStatus()));}
		
	

	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@Validated @RequestBody RegisterRequest signUpRequest) {

		if (repository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity.badRequest().body(new Message("Error: Email is already in use!"));
		}
		// Create new user's account
		User user = new User(signUpRequest.getUsername(), signUpRequest.getEmail(),
				encoder.encode(signUpRequest.getPassword()), signUpRequest.getRole(),false);
		repository.save(user);

		return ResponseEntity.ok(new Message("User registered successfully!"));
	}
	

	  

	

}