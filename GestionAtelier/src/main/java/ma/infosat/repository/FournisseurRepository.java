package ma.infosat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.infosat.model.Fournisseur;

public interface FournisseurRepository extends JpaRepository<Fournisseur, Integer> {
	
}
