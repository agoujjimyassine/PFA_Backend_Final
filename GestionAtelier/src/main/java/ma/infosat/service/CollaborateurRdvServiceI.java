package ma.infosat.service;

import java.util.List;
import java.util.Optional;

import ma.infosat.model.CollaborateurRdv;

public interface CollaborateurRdvServiceI {
	public CollaborateurRdv add(CollaborateurRdv collaborateurRdv);

	public Optional<CollaborateurRdv> find(Integer id);

	public CollaborateurRdv edit(CollaborateurRdv collaborateurRdv);

	public void delete(Integer id);

	public List<CollaborateurRdv> getAll();
	
	public List<CollaborateurRdv> getByIdRendezVous(Integer id);
}
