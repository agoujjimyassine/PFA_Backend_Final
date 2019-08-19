package ma.infosat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.infosat.model.Expert;

public interface ExpertRepository extends JpaRepository<Expert, Integer>{

}
