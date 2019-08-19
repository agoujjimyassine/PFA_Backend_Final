package ma.infosat.service;

import java.util.List;
import java.util.Optional;

import ma.infosat.model.TypeCarburant;

public interface TypeCarburantServiceI {
	public TypeCarburant add(TypeCarburant typeCarburant);

	public Optional<TypeCarburant> find(Integer id);

	public TypeCarburant edit(TypeCarburant typeCarburant);

	public void delete(Integer id);

	public List<TypeCarburant> getAll();
}
