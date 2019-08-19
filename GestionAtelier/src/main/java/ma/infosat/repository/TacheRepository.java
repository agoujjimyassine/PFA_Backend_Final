package ma.infosat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.infosat.model.Tache;

public interface TacheRepository extends JpaRepository<Tache, Integer> {

}
