package edu.projet.pfe.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.projet.pfe.entities.Arret;
import edu.projet.pfe.entities.Lignes;
import edu.projet.pfe.entities.Services;


@Repository
public interface LignesRepository extends JpaRepository<Lignes, Long> {
	public List<Lignes> findByArretdepart(Arret arretdepart);
	public List<Lignes> findByArretarrivee(Arret arretarrivee);
}
