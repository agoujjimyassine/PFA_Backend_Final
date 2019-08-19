package ma.infosat.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.infosat.model.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer>{

	   Optional<Utilisateur> findByUsername(String username);
	    Boolean existsByUsername(String username);
	    Boolean existsByEmail(String email);
	
}

