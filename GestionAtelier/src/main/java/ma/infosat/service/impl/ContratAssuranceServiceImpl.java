package ma.infosat.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.infosat.model.ContratAssurance;
import ma.infosat.model.Dossier;
import ma.infosat.repository.ContratAssuranceRepository;
import ma.infosat.service.ContratAssuranceServiceI;
import ma.infosat.service.DossierServiceI;

@Service
@Transactional
public class ContratAssuranceServiceImpl implements ContratAssuranceServiceI {

	private static final Logger LOGGER = LoggerFactory.getLogger(ContratAssuranceServiceImpl.class);

	@Autowired
	private ContratAssuranceRepository contratAssuranceRepository;
	
	@Autowired
	private DossierServiceI dossierService;

	@Override
	public ContratAssurance add(ContratAssurance contratAssurance) {
		if (contratAssurance != null)
			return contratAssuranceRepository.save(contratAssurance);
		else
			return null;
	}

	@Override
	public Optional<ContratAssurance> find(Integer id) {
		return contratAssuranceRepository.findById(id);
	}

	@Override
	public ContratAssurance edit(ContratAssurance contratAssurance) {
		if (contratAssurance != null)
			return contratAssuranceRepository.save(contratAssurance);
		else
			return null;
	}

	@Override
	public void delete(Integer id) {
		if (contratAssuranceRepository.findById(id) != null)
			contratAssuranceRepository.deleteById(id);
	}

	@Override
	public List<ContratAssurance> getAll() {
		try {
			List<ContratAssurance> contratAssurances = contratAssuranceRepository.findAll();
			if (contratAssurances.isEmpty())
				return contratAssurances;
			else
				return Collections.emptyList();
		} catch (Exception e) {
			LOGGER.error("Erreur {} ", e);
			return Collections.emptyList();
		}
	}

	@Override
	public List<ContratAssurance> getByIdDossier(Integer id) {
			Optional<Dossier> dossier=dossierService.find(id);
			List<ContratAssurance> contratAssurances=dossier.get().getAgenceAssurance().getContratAssurances();
			return contratAssurances;
	}

}