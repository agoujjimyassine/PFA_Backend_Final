package ma.infosat.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import ma.infosat.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer>{

}
