package ma.infosat.service;

import java.util.List;
import java.util.Optional;

import ma.infosat.model.ContratAssurance;

public interface ContratAssuranceServiceI {
	public ContratAssurance add(ContratAssurance contratAssurance);

	public Optional<ContratAssurance> find(Integer id);

	public ContratAssurance edit(ContratAssurance contratAssurance);

	public void delete(Integer id);

	public List<ContratAssurance> getAll();
	
	public List<ContratAssurance> getByIdDossier(Integer id);
}
