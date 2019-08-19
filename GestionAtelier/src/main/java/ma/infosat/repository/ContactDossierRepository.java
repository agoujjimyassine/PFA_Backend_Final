package ma.infosat.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import ma.infosat.model.ContactDossier;

public interface ContactDossierRepository extends JpaRepository<ContactDossier, Integer>{

}
