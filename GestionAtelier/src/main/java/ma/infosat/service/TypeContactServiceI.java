package ma.infosat.service;

import java.util.List;
import java.util.Optional;

import ma.infosat.model.TypeContact;

public interface TypeContactServiceI {
	public TypeContact add(TypeContact typeContact);

	public Optional<TypeContact> find(Integer id);

	public TypeContact edit(TypeContact typeContact);

	public void delete(Integer id);

	public List<TypeContact> getAll();
}
