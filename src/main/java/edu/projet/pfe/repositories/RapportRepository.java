package edu.projet.pfe.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.projet.pfe.entities.Rapport1;
import edu.projet.pfe.entities.User;

public interface RapportRepository extends JpaRepository<Rapport1, Long> {
	List<Rapport1> findByUser(User user);
}
