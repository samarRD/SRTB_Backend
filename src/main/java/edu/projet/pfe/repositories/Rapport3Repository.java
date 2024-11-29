package edu.projet.pfe.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.projet.pfe.entities.Rapport1;
import edu.projet.pfe.entities.Rapport3;
import edu.projet.pfe.entities.User;

@Repository
public interface Rapport3Repository extends JpaRepository<Rapport3, Long> {
	List<Rapport3> findByUser(User user);
}
