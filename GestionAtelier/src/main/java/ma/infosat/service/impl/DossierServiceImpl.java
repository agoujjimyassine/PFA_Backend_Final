package ma.infosat.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.infosat.model.AgenceAssurance;
import ma.infosat.model.Dossier;
import ma.infosat.repository.DossierRepository;
import ma.infosat.service.AgenceAssuranceServiceI;
import ma.infosat.service.DossierServiceI;

@Service
@Transactional
public class DossierServiceImpl implements DossierServiceI{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DossierServiceImpl.class);

	@Autowired
	private DossierRepository dossierRepository;
	
	@Autowired
	private AgenceAssuranceServiceI agenceAssuranceService;
	
	@Override
	public Dossier add(Dossier dossier) {
		if (dossier != null)
			return dossierRepository.save(dossier);
		else
			return null;
	}

	@Override
	public Optional<Dossier> find(Integer id) {
		return dossierRepository.findById(id);
	}

	@Override
	public Dossier edit(Dossier dossier) {
		if (dossier != null)
			return dossierRepository.save(dossier);
		else
			return null;
	}

	@Override
	public void delete(Integer id) {
		if (dossierRepository.findById(id) != null)
			dossierRepository.deleteById(id);
	}

	@Override
	public List<Dossier> getAll() {
		try {
			List<Dossier> dossiers = dossierRepository.findAll();
			if (dossiers.isEmpty())
				return dossiers;
			else
				return Collections.emptyList();
		} catch (Exception e) {
			LOGGER.error("Erreur {} ", e);
			return Collections.emptyList();
		}
	}

	@Override
	public List<Dossier> getByIdAgenceAssurance(Integer id) {
		Optional<AgenceAssurance> agenceAssurance=agenceAssuranceService.find(id);
		List<Dossier> dossiers=agenceAssurance.get().getDossiers();
		return dossiers;
	}

}
