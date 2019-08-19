package ma.infosat.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.infosat.model.TypeCarburant;
import ma.infosat.repository.TypeCarburantRepository;
import ma.infosat.service.TypeCarburantServiceI;

@Service
@Transactional
public class TypeCarburantServiceImpl implements TypeCarburantServiceI {

	private static final Logger LOGGER = LoggerFactory.getLogger(TypeCarburantServiceImpl.class);

	@Autowired
	private TypeCarburantRepository typeCarburantRepository;

	@Override
	public TypeCarburant add(TypeCarburant typeCarburant) {
		if (typeCarburant != null)
			return typeCarburantRepository.save(typeCarburant);
		else
			return null;
	}

	@Override
	public Optional<TypeCarburant> find(Integer id) {
		return typeCarburantRepository.findById(id);
	}

	@Override
	public TypeCarburant edit(TypeCarburant typeCarburant) {
		if (typeCarburant != null)
			return typeCarburantRepository.save(typeCarburant);
		else
			return null;
	}

	@Override
	public void delete(Integer id) {
		if (typeCarburantRepository.findById(id) != null)
			typeCarburantRepository.deleteById(id);
	}

	@Override
	public List<TypeCarburant> getAll() {
		try {
			List<TypeCarburant> typeCarburants = typeCarburantRepository.findAll();
			if (typeCarburants.isEmpty())
				return typeCarburants;
			else
				return Collections.emptyList();
		} catch (Exception e) {
			LOGGER.error("Erreur {} ", e);
			return Collections.emptyList();
		}
	}

}
