package ma.infosat.service;

import java.util.List;
import java.util.Optional;

import ma.infosat.model.Collaborateur;

public interface CollaborateurServiceI {
	public Collaborateur add(Collaborateur collaborateur);

	public Optional<Collaborateur> find(Integer id);

	public Collaborateur edit(Collaborateur collaborateur);

	public void delete(Integer id);

	public List<Collaborateur> getAll();
}
