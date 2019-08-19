package ma.infosat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.infosat.model.Commande;

public interface CommandeRepository extends JpaRepository<Commande, Integer> {

}
