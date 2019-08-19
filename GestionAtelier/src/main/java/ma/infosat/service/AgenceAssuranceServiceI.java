package ma.infosat.service;

import java.util.List;
import java.util.Optional;

import ma.infosat.model.AgenceAssurance;

public interface AgenceAssuranceServiceI {
	public AgenceAssurance add(AgenceAssurance agenceAssurance);

	public Optional<AgenceAssurance> find(Integer id);

	public AgenceAssurance edit(AgenceAssurance agenceAssurance);

	public void delete(Integer id);

	public List<AgenceAssurance> getAll();
	
	public List<AgenceAssurance> geByIdCompagnieAssurance(Integer id);
}
