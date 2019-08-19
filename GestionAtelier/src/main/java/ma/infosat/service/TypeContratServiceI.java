package ma.infosat.service;

import java.util.List;
import java.util.Optional;

import ma.infosat.model.TypeContrat;

public interface TypeContratServiceI {
	public TypeContrat add(TypeContrat typeContrat);

	public Optional<TypeContrat> find(Integer id);

	public TypeContrat edit(TypeContrat typeContrat);

	public void delete(Integer id);

	public List<TypeContrat> getAll();
}
