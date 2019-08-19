package ma.infosat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.infosat.model.EtatPiece;

public interface EtatPieceRepository  extends JpaRepository<EtatPiece, Integer> {

}
