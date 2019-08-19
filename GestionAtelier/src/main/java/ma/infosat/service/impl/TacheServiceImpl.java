package ma.infosat.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.infosat.model.DemandeReparation;
import ma.infosat.model.Tache;
import ma.infosat.repository.TacheRepository;
import ma.infosat.service.DemandeReparationServiceI;
import ma.infosat.service.TacheServiceI;

@Service
@Transactional
public class TacheServiceImpl implements TacheServiceI{

	private static final Logger LOGGER = LoggerFactory.getLogger(ClientServiceImpl.class);

	@Autowired
	private TacheRepository tacheRepository;
	
	@Autowired
	private DemandeReparationServiceI demandeReparationService;
	
	@Override
	public Tache add(Tache tache) {
		if (tache != null)
			return tacheRepository.save(tache);
		else
			return null;
	}

	@Override
	public Optional<Tache> find(Integer id) {
		return tacheRepository.findById(id);
	}

	@Override
	public Tache edit(Tache tache) {
		if (tache != null)
			return tacheRepository.save(tache);
		else
			return null;

	}

	@Override
	public void delete(Integer id) {
		if (tacheRepository.findById(id) != null)
			tacheRepository.deleteById(id);
		
	}

	@Override
	public List<Tache> getAll() {
		try {
			List<Tache> taches = tacheRepository.findAll();
			if (taches.isEmpty())
				return taches;
			else
				return Collections.emptyList();
		} catch (Exception e) {
			LOGGER.error("Erreur {} ", e);
			return Collections.emptyList();
		}
	}

	@Override
	public List<Tache> getByIdDemandeReparation(Integer id) {
		Optional<DemandeReparation> demandeReparation=demandeReparationService.find(id);
		List<Tache> taches=demandeReparation.get().getTaches();
		return taches;
	}

}
