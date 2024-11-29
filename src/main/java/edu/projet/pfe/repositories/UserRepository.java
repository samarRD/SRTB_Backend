package edu.projet.pfe.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.projet.pfe.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	Optional<User> findByEmail(String email);
	
	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
	
	public User findByEmailAndPassword(String email,String password);
	
	
}