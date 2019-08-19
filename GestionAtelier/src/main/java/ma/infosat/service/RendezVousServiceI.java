package ma.infosat.service;

import java.util.List;
import java.util.Optional;


import ma.infosat.model.RendezVous;

public interface RendezVousServiceI {
	public RendezVous add(RendezVous rendezVous);

	public Optional<RendezVous> find(Integer id);

	public RendezVous edit(RendezVous rendezVous);

	public void delete(Integer id);

	public List<RendezVous> getAll();
	
	public List<RendezVous> getByIdDossier(Integer id); 
}
