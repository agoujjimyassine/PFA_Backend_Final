package ma.infosat.service;

import java.util.List;
import java.util.Optional;

import ma.infosat.model.EtatPiece;

public interface EtatPieceServiceI {

	public EtatPiece add(EtatPiece etatPiece);

	public Optional<EtatPiece> find(Integer id);

	public EtatPiece edit(EtatPiece etatPiece);

	public void delete(Integer id);

	public List<EtatPiece> getAll();
	
}
