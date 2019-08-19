package ma.infosat.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.infosat.model.TypeClient;
import ma.infosat.repository.TypeClientRepository;
import ma.infosat.service.TypeClientServiceI;

@Service
@Transactional
public class TypeClientServiceImpl implements TypeClientServiceI {

	private static final Logger LOGGER = LoggerFactory.getLogger(TypeClientServiceImpl.class);

	@Autowired
	private TypeClientRepository typeClientRepository;

	@Override
	public TypeClient add(TypeClient typeClient) {
		if (typeClient != null)
			return typeClientRepository.save(typeClient);
		else
			return null;
	}

	@Override
	public Optional<TypeClient> find(Integer id) {
		return typeClientRepository.findById(id);
	}

	@Override
	public TypeClient edit(TypeClient typeClient) {
		if (typeClient != null)
			return typeClientRepository.save(typeClient);
		else
			return null;
	}

	@Override
	public void delete(Integer id) {
		if (typeClientRepository.findById(id) != null)
			typeClientRepository.deleteById(id);
	}

	@Override
	public List<TypeClient> getAll() {
		try {
			List<TypeClient> typeClients = typeClientRepository.findAll();
			if (typeClients.isEmpty())
				return typeClients;
			else
				return Collections.emptyList();
		} catch (Exception e) {
			LOGGER.error("Erreur {} ", e);
			return Collections.emptyList();
		}
	}

}