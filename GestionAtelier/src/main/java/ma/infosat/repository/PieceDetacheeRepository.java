package ma.infosat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ma.infosat.model.PieceDetachee;

public interface PieceDetacheeRepository extends JpaRepository<PieceDetachee, Integer> {
	@Query(value="SELECT COUNT(*) FROM PieceDetachee AS PD,Dossier AS D WHERE PD.dossier.id=D.id and PD.nom LIKE :x")
	public Integer countPieceDetacheeByNom(@Param("x") String x);
}
