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
import ma.infosat.model.RendezVous;
import ma.infosat.repository.RendezVousRepository;
import ma.infosat.service.DossierServiceI;
import ma.infosat.service.RendezVousServiceI;

@Service
@Transactional
public class RendezVousServiceImpl implements RendezVousServiceI {

	private static final Logger LOGGER = LoggerFactory.getLogger(RendezVousServiceImpl.class);

	@Autowired
	private RendezVousRepository rendezVousRepository;
	
	@Autowired
	private DossierServiceI dossierService;

	@Override
	public RendezVous add(RendezVous rendezVous) {
		if (rendezVous != null)
			return rendezVousRepository.save(rendezVous);
		else
			return null;
	}

	@Override
	public Optional<RendezVous> find(Integer id) {
		return rendezVousRepository.findById(id);
	}

	@Override
	public RendezVous edit(RendezVous rendezVous) {
		if (rendezVous != null)
			return rendezVousRepository.save(rendezVous);
		else
			return null;
	}

	@Override
	public void delete(Integer id) {
		if (rendezVousRepository.findById(id) != null)
			rendezVousRepository.deleteById(id);
	}
	
	@Override
	public List<RendezVous> getAll() {
		try {
			List<RendezVous> rendezVouss = rendezVousRepository.findAll();
			if (rendezVouss.isEmpty())
				return rendezVouss;
			else
				return Collections.emptyList();
		} catch (Exception e) {
			LOGGER.error("Erreur {} ", e);
			return Collections.emptyList();
		}
	}

	@Override
	public List<RendezVous> getByIdDossier(Integer id) {
		Optional<Dossier> dossier=dossierService.find(id);
		List<RendezVous> rendezVouss=dossier.get().getRendezVouss();
		return rendezVouss;
	}

}
