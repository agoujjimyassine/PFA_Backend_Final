package ma.infosat.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.infosat.model.Dossier;
import ma.infosat.model.Expert;
import ma.infosat.model.ExpertDossier;
import ma.infosat.repository.ExpertDossierRepository;
import ma.infosat.service.DossierServiceI;
import ma.infosat.service.ExpertDossierServiceI;
import ma.infosat.service.ExpertServiceI;

@Service
@Transactional
public class ExpertDossierServiceImpl implements ExpertDossierServiceI {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExpertDossierServiceImpl.class);

	@Autowired
	private ExpertDossierRepository expertDossierRepository;
	
	@Autowired
	private DossierServiceI dossierService;
	
	@Autowired
	private ExpertServiceI expertService;

	@Override
	public ExpertDossier add(ExpertDossier expertDossier) {
		if (expertDossier != null)
			return expertDossierRepository.save(expertDossier);
		else
			return null;
	}

	@Override
	public Optional<ExpertDossier> find(Integer id) {
		return expertDossierRepository.findById(id);
	}

	@Override
	public ExpertDossier edit(ExpertDossier expertDossier) {
		if (expertDossier != null)
			return expertDossierRepository.save(expertDossier);
		else
			return null;
	}

	@Override
	public void delete(Integer id) {
		if (expertDossierRepository.findById(id) != null)
			expertDossierRepository.deleteById(id);
	}

	@Override
	public List<ExpertDossier> getAll() {
		try {
			List<ExpertDossier> expertDossiers = expertDossierRepository.findAll();
			if (expertDossiers.isEmpty())
				return expertDossiers;
			else
				return Collections.emptyList();
		} catch (Exception e) {
			LOGGER.error("Erreur {} ", e);
			return Collections.emptyList();
		}
	}

	@Override
	public List<ExpertDossier> getByIdDossier(Integer id) {
		Optional<Dossier> dossier=dossierService.find(id);
		List<ExpertDossier> expertDossiers=dossier.get().getExpertDossiers();
		return expertDossiers;
	}

	@Override
	public List<ExpertDossier> getByIdExpert(Integer id) {
		Optional<Expert> expert=expertService.find(id);
		List<ExpertDossier> expertDossiers=expert.get().getExpertDossiers();
		return expertDossiers;
	}

}
