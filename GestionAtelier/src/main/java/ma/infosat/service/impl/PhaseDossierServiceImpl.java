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
import ma.infosat.model.PhaseDossier;
import ma.infosat.repository.PhaseDossierRepository;
import ma.infosat.service.DossierServiceI;
import ma.infosat.service.PhaseDossierServiceI;

@Service
@Transactional
public class PhaseDossierServiceImpl implements PhaseDossierServiceI {

	private static final Logger LOGGER = LoggerFactory.getLogger(PhaseDossierServiceImpl.class);

	@Autowired
	private PhaseDossierRepository phaseDossierRepository;
	
	@Autowired
	private DossierServiceI dossierService;

	@Override
	public PhaseDossier add(PhaseDossier phaseDossier) {
		if (phaseDossier != null)
			return phaseDossierRepository.save(phaseDossier);
		else
			return null;
	}

	@Override
	public Optional<PhaseDossier> find(Integer id) {
		return phaseDossierRepository.findById(id);
	}

	@Override
	public PhaseDossier edit(PhaseDossier phaseDossier) {
		if (phaseDossier != null)
			return phaseDossierRepository.save(phaseDossier);
		else
			return null;
	}

	@Override
	public void delete(Integer id) {
		if (phaseDossierRepository.findById(id) != null)
			phaseDossierRepository.deleteById(id);
	}
	
	@Override
	public List<PhaseDossier> getAll() {
		try {
			List<PhaseDossier> phaseDossiers = phaseDossierRepository.findAll();
			if (phaseDossiers.isEmpty())
				return phaseDossiers;
			else
				return Collections.emptyList();
		} catch (Exception e) {
			LOGGER.error("Erreur {} ", e);
			return Collections.emptyList();
		}
	}

	@Override
	public List<PhaseDossier> getByIdDossier(Integer id) {
		Optional<Dossier> dossier=dossierService.find(id);
		List<PhaseDossier> phaseDossiers=dossier.get().getPhaseDossiers();
		return phaseDossiers;
	}

}