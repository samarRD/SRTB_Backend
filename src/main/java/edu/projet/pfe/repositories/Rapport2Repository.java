package edu.projet.pfe.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.projet.pfe.entities.Rapport2;
import edu.projet.pfe.entities.Vehicule;
@Repository
public interface Rapport2Repository extends JpaRepository<Rapport2, Long> {
	List<Rapport2> findByVehicule(Vehicule vehicule);

}
