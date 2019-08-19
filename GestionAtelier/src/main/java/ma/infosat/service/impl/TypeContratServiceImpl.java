package ma.infosat.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.infosat.model.TypeContrat;
import ma.infosat.repository.TypeContratRepository;
import ma.infosat.service.TypeContratServiceI;

@Service
@Transactional
public class TypeContratServiceImpl implements TypeContratServiceI {

	private static final Logger LOGGER = LoggerFactory.getLogger(TypeContratServiceImpl.class);

	@Autowired
	private TypeContratRepository typeContratRepository;

	@Override
	public TypeContrat add(TypeContrat typeContrat) {
		if (typeContrat != null)
			return typeContratRepository.save(typeContrat);
		else
			return null;
	}

	@Override
	public Optional<TypeContrat> find(Integer id) {
		return typeContratRepository.findById(id);
	}

	@Override
	public TypeContrat edit(TypeContrat typeContrat) {
		if (typeContrat != null)
			return typeContratRepository.save(typeContrat);
		else
			return null;
	}

	@Override
	public void delete(Integer id) {
		if (typeContratRepository.findById(id) != null)
			typeContratRepository.deleteById(id);
	}

	@Override
	public List<TypeContrat> getAll() {
		try {
			List<TypeContrat> typeContrats = typeContratRepository.findAll();
			if (typeContrats.isEmpty())
				return typeContrats;
			else
				return Collections.emptyList();
		} catch (Exception e) {
			LOGGER.error("Erreur {} ", e);
			return Collections.emptyList();
		}
	}

}