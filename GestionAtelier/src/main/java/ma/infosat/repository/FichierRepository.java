package ma.infosat.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import ma.infosat.model.Fichier;

public interface FichierRepository extends JpaRepository<Fichier, Integer>{

}
