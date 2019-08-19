package ma.infosat.service;

import java.util.List;
import java.util.Optional;

import ma.infosat.model.PhaseDossier;

public interface PhaseDossierServiceI {
	public PhaseDossier add(PhaseDossier phaseDossier);

	public Optional<PhaseDossier> find(Integer id);

	public PhaseDossier edit(PhaseDossier phaseDossier);

	public void delete(Integer id);

	public List<PhaseDossier> getAll();
	
	public List<PhaseDossier> getByIdDossier(Integer id);
}
