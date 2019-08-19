package ma.infosat.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.infosat.model.Role;
import ma.infosat.model.RoleNom;;

public interface RoleRepository extends JpaRepository<Role, Integer>{
	
	 Optional<Role> findByNom(RoleNom roleNom);
	
}
