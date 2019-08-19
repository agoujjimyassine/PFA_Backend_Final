package ma.infosat.service;

import java.util.List;
import java.util.Optional;

import ma.infosat.model.ExpertDossier;

public interface ExpertDossierServiceI {
	public ExpertDossier add(ExpertDossier expertDossier);

	public Optional<ExpertDossier> find(Integer id);

	public ExpertDossier edit(ExpertDossier expertDossier);

	public void delete(Integer id);

	public List<ExpertDossier> getAll();
	
	public List<ExpertDossier> getByIdDossier(Integer id);
	
	public List<ExpertDossier> getByIdExpert(Integer id);

}
