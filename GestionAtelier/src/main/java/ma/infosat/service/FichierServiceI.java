package ma.infosat.service;

import java.util.List;
import java.util.Optional;

import ma.infosat.model.Fichier;

public interface FichierServiceI {
	public Fichier add(Fichier fichier);

	public Optional<Fichier> find(Integer id);

	public Fichier edit(Fichier fichier);

	public void delete(Integer id);

	public List<Fichier> getAll();
	
	public List<Fichier> getByIdDossier(Integer id);
}
