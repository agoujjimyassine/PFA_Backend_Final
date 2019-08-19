package ma.infosat.service;

import java.util.List;
import java.util.Optional;

import ma.infosat.model.TypeClient;

public interface TypeClientServiceI {
	public TypeClient add(TypeClient typeClient);

	public Optional<TypeClient> find(Integer id);

	public TypeClient edit(TypeClient typeClient);

	public void delete(Integer id);

	public List<TypeClient> getAll();
}
