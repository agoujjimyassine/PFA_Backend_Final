package ma.infosat.service;

import java.util.List;
import java.util.Optional;

import ma.infosat.model.PieceDetachee;

public interface PieceDetacheeServiceI {
	public PieceDetachee add(PieceDetachee pieceDetachee);

	public Optional<PieceDetachee> find(Integer id);

	public PieceDetachee edit(PieceDetachee pieceDetachee);

	public void delete(Integer id);

	public List<PieceDetachee> getAll();
	
	public List<PieceDetachee> getByIdDossier(Integer id);
	
	public List<PieceDetachee> getByIdCommande(Integer id);
}
