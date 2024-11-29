package edu.projet.pfe.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.projet.pfe.entities.Type;




@Repository
public interface TypeRepository extends JpaRepository<Type, Long> {

}
