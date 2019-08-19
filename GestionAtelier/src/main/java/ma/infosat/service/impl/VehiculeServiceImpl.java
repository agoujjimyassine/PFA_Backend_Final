package ma.infosat.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.infosat.model.Vehicule;
import ma.infosat.repository.VehiculeRepository;
import ma.infosat.service.VehiculeServiceI;

@Service
@Transactional
public class VehiculeServiceImpl implements VehiculeServiceI {

	private static final Logger LOGGER = LoggerFactory.getLogger(VehiculeServiceImpl.class);

	@Autowired
	private VehiculeRepository vehiculeRepository;

	@Override
	public Vehicule add(Vehicule vehicule) {
		if (vehicule != null)
			return vehiculeRepository.save(vehicule);
		else
			return null;
	}

	@Override
	public Optional<Vehicule> find(Integer id) {
		return vehiculeRepository.findById(id);
	}

	@Override
	public Vehicule edit(Vehicule vehicule) {
		if (vehicule != null)
			return vehiculeRepository.save(vehicule);
		else
			return null;
	}

	@Override
	public void delete(Integer id) {
		if (vehiculeRepository.findById(id) != null)
			vehiculeRepository.deleteById(id);
	}

	@Override
	public List<Vehicule> getAll() {
		try {
			List<Vehicule> vehicules = vehiculeRepository.findAll();
			if (vehicules.isEmpty())
				return vehicules;
			else
				return Collections.emptyList();
		} catch (Exception e) {
			LOGGER.error("Erreur {} ", e);
			return Collections.emptyList();
		}
	}

}