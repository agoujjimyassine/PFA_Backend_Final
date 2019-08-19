package ma.infosat.service;

import java.util.List;
import java.util.Optional;

import ma.infosat.model.Tache;

public interface TacheServiceI {

	public Tache add(Tache tache);

	public Optional<Tache> find(Integer id);

	public Tache edit(Tache tache);

	public void delete(Integer id);

	public List<Tache> getAll();
	
	public List<Tache> getByIdDemandeReparation(Integer id); 
}
