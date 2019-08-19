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
import ma.infosat.repository.DemandeReparationRepository;
import ma.infosat.service.DemandeReparationServiceI;

@Service
@Transactional
public class DemandeReparationServiceImpl implements DemandeReparationServiceI{

	private static final Logger LOGGER = LoggerFactory.getLogger(ClientServiceImpl.class);
	
	@Autowired
	private DemandeReparationRepository demandeReparationRepository;
	
	@Override
	public DemandeReparation add(DemandeReparation demandeReparation) {
		if (demandeReparation != null)
			return demandeReparationRepository.save(demandeReparation);
		else
			return null;
	}

	@Override
	public Optional<DemandeReparation> find(Integer id) {
		return demandeReparationRepository.findById(id);
	}

	@Override
	public DemandeReparation edit(DemandeReparation demandeReparation) {
		if (demandeReparation != null)
			return demandeReparationRepository.save(demandeReparation);
		else
			return null;
	}

	@Override
	public void delete(Integer id) {
		if (demandeReparationRepository.findById(id) != null)
			demandeReparationRepository.deleteById(id);
		
	}

	@Override
	public List<DemandeReparation> getAll() {
		try {
			List<DemandeReparation> demandeReparations = demandeReparationRepository.findAll();
			if (demandeReparations.isEmpty())
				return demandeReparations;
			else
				return Collections.emptyList();
		} catch (Exception e) {
			LOGGER.error("Erreur {} ", e);
			return Collections.emptyList();
		}
	}

}
