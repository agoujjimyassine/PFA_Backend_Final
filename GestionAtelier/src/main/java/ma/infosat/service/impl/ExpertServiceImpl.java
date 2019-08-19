package ma.infosat.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.infosat.model.Expert;
import ma.infosat.repository.ExpertRepository;
import ma.infosat.service.ExpertServiceI;

@Service
@Transactional
public class ExpertServiceImpl implements ExpertServiceI {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExpertServiceImpl.class);

	@Autowired
	private ExpertRepository expertRepository;

	@Override
	public Expert add(Expert expert) {
		if (expert != null)
			return expertRepository.save(expert);
		else
			return null;
	}

	@Override
	public Optional<Expert> find(Integer id) {
		return expertRepository.findById(id);
	}

	@Override
	public Expert edit(Expert expert) {
		if (expert != null)
			return expertRepository.save(expert);
		else
			return null;
	}

	@Override
	public void delete(Integer id) {
		if (expertRepository.findById(id) != null)
			expertRepository.deleteById(id);
	}

	@Override
	public List<Expert> getAll() {
		try {
			List<Expert> experts = expertRepository.findAll();
			if (experts.isEmpty())
				return experts;
			else
				return Collections.emptyList();
		} catch (Exception e) {
			LOGGER.error("Erreur {} ", e);
			return Collections.emptyList();
		}
	}

}
