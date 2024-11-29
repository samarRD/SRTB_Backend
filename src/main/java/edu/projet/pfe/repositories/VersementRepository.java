package edu.projet.pfe.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import edu.projet.pfe.entities.Versement;

@Repository
public interface VersementRepository extends  JpaRepository<Versement, Long>{

}
