package ma.infosat.service;

import java.util.List;
import java.util.Optional;

import ma.infosat.model.DemandeReparation;

public interface DemandeReparationServiceI {

	public DemandeReparation add(DemandeReparation demandeReparation);

	public Optional<DemandeReparation> find(Integer id);

	public DemandeReparation edit(DemandeReparation demandeReparation);

	public void delete(Integer id);

	public List<DemandeReparation> getAll();
	
}
