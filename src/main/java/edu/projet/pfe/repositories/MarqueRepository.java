package edu.projet.pfe.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.projet.pfe.entities.Marque;
import edu.projet.pfe.entities.Vehicule;


@Repository
public interface MarqueRepository extends JpaRepository<Marque, Long> {



}
