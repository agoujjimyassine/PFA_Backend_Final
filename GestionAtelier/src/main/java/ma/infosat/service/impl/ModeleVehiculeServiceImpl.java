package ma.infosat.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.infosat.model.ModeleVehicule;
import ma.infosat.repository.ModeleVehiculeRepository;
import ma.infosat.service.ModeleVehiculeServiceI;

@Service
@Transactional
public class ModeleVehiculeServiceImpl implements ModeleVehiculeServiceI {

	private static final Logger LOGGER = LoggerFactory.getLogger(ModeleVehiculeServiceImpl.class);

	@Autowired
	private ModeleVehiculeRepository modeleVehiculeRepository;

	@Override
	public ModeleVehicule add(ModeleVehicule modeleVehicule) {
		if (modeleVehicule != null)
			return modeleVehiculeRepository.save(modeleVehicule);
		else
			return null;
	}

	@Override
	public Optional<ModeleVehicule> find(Integer id) {
		return modeleVehiculeRepository.findById(id);
	}

	@Override
	public ModeleVehicule edit(ModeleVehicule modeleVehicule) {
		if (modeleVehicule != null)
			return modeleVehiculeRepository.save(modeleVehicule);
		else
			return null;
	}

	@Override
	public void delete(Integer id) {
		if (modeleVehiculeRepository.findById(id) != null)
			modeleVehiculeRepository.deleteById(id);
	}

	@Override
	public List<ModeleVehicule> getAll() {
		try {
			List<ModeleVehicule> modeleVehicules = modeleVehiculeRepository.findAll();
			if (modeleVehicules.isEmpty())
				return modeleVehicules;
			else
				return Collections.emptyList();
		} catch (Exception e) {
			LOGGER.error("Erreur {} ", e);
			return Collections.emptyList();
		}
	}

}
