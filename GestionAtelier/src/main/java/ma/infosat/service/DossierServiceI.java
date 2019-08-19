package ma.infosat.service;

import java.util.List;
import java.util.Optional;

import ma.infosat.model.Dossier;

public interface DossierServiceI {
	public Dossier add(Dossier dossier);
				
	public Optional<Dossier> find(Integer id);

	public Dossier edit(Dossier dossier);
	
	public void delete(Integer id);

	public List<Dossier> getAll();
	
	public List<Dossier> getByIdAgenceAssurance(Integer id);
}
