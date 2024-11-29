package edu.projet.pfe.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.projet.pfe.entities.Services;

import edu.projet.pfe.entities.Voyage;

public interface VoyageRepository extends JpaRepository<Voyage, Long>{
	public Voyage findByService(Services service);
}
