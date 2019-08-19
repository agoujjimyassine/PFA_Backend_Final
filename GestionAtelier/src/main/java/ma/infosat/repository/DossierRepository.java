package ma.infosat.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import ma.infosat.model.Dossier;

public interface DossierRepository extends JpaRepository<Dossier, Integer>{

}
