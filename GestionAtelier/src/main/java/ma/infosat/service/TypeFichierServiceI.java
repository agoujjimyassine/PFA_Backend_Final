package ma.infosat.service;

import java.util.List;
import java.util.Optional;

import ma.infosat.model.TypeFichier;

public interface TypeFichierServiceI {
	public TypeFichier add(TypeFichier typeFichier);

	public Optional<TypeFichier> find(Integer id);

	public TypeFichier edit(TypeFichier typeFichier);

	public void delete(Integer id);

	public List<TypeFichier> getAll();
}
