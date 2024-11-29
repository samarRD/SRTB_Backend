package edu.projet.pfe.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.projet.pfe.entities.Marque;
import edu.projet.pfe.entities.Type;
import edu.projet.pfe.entities.Vehicule;

public interface VehiculeRepository extends JpaRepository<Vehicule, Long> {
	public List<Vehicule> findByType(Type type);

	public List<Vehicule> findByMarque(Marque m);
}
