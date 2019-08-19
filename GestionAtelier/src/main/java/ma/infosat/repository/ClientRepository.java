package ma.infosat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.infosat.model.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {
	
}
