package edu.projet.pfe.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.projet.pfe.entities.Arret;
import edu.projet.pfe.entities.Lignes;


	public interface ArretRepository extends JpaRepository<Arret, Long>{
}
