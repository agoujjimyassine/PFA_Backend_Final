package ma.infosat.service;

import java.util.List;
import java.util.Optional;

import ma.infosat.model.CompagnieAssurance;

public interface CompagnieAssuranceServiceI {
	public CompagnieAssurance add(CompagnieAssurance compagnieAssurance);

	public Optional<CompagnieAssurance> find(Integer id);

	public CompagnieAssurance edit(CompagnieAssurance compagnieAssurance);

	public void delete(Integer id);

	public List<CompagnieAssurance> getAll();
}
