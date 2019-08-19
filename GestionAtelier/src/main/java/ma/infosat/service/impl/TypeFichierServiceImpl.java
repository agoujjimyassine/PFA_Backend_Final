package ma.infosat.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.infosat.model.TypeFichier;
import ma.infosat.repository.TypeFichierRepository;
import ma.infosat.service.TypeFichierServiceI;

@Service
@Transactional
public class TypeFichierServiceImpl implements TypeFichierServiceI {

	private static final Logger LOGGER = LoggerFactory.getLogger(TypeFichierServiceImpl.class);

	@Autowired
	private TypeFichierRepository typeFichierRepository;

	@Override
	public TypeFichier add(TypeFichier typeFichier) {
		if (typeFichier != null)
			return typeFichierRepository.save(typeFichier);
		else
			return null;
	}

	@Override
	public Optional<TypeFichier> find(Integer id) {
		return typeFichierRepository.findById(id);
	}

	@Override
	public TypeFichier edit(TypeFichier typeFichier) {
		if (typeFichier != null)
			return typeFichierRepository.save(typeFichier);
		else
			return null;
	}

	@Override
	public void delete(Integer id) {
		if (typeFichierRepository.findById(id) != null)
			typeFichierRepository.deleteById(id);
	}

	@Override
	public List<TypeFichier> getAll() {
		try {
			List<TypeFichier> typeFichiers = typeFichierRepository.findAll();
			if (typeFichiers.isEmpty())
				return typeFichiers;
			else
				return Collections.emptyList();
		} catch (Exception e) {
			LOGGER.error("Erreur {} ", e);
			return Collections.emptyList();
		}
	}

}
