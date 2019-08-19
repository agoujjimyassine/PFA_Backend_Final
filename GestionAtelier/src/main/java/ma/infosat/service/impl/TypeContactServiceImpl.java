package ma.infosat.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.infosat.model.TypeContact;
import ma.infosat.repository.TypeContactRepository;
import ma.infosat.service.TypeContactServiceI;

@Service
@Transactional
public class TypeContactServiceImpl implements TypeContactServiceI {

	private static final Logger LOGGER = LoggerFactory.getLogger(TypeContactServiceImpl.class);

	@Autowired
	private TypeContactRepository typeContactRepository;

	@Override
	public TypeContact add(TypeContact typeContact) {
		if (typeContact != null)
			return typeContactRepository.save(typeContact);
		else
			return null;
	}

	@Override
	public Optional<TypeContact> find(Integer id) {
		return typeContactRepository.findById(id);
	}

	@Override
	public TypeContact edit(TypeContact typeContact) {
		if (typeContact != null)
			return typeContactRepository.save(typeContact);
		else
			return null;
	}

	@Override
	public void delete(Integer id) {
		if (typeContactRepository.findById(id) != null)
			typeContactRepository.deleteById(id);
	}
	
	@Override
	public List<TypeContact> getAll() {
		try {
			List<TypeContact> typeContacts = typeContactRepository.findAll();
			if (typeContacts.isEmpty())
				return typeContacts;
			else
				return Collections.emptyList();
		} catch (Exception e) {
			LOGGER.error("Erreur {} ", e);
			return Collections.emptyList();
		}
	}

}