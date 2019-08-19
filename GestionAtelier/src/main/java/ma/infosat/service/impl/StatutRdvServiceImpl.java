package ma.infosat.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.infosat.model.StatutRdv;
import ma.infosat.repository.StatutRdvRepository;
import ma.infosat.service.StatutRdvServiceI;

@Service
@Transactional
public class StatutRdvServiceImpl implements StatutRdvServiceI {

	private static final Logger LOGGER = LoggerFactory.getLogger(StatutRdvServiceImpl.class);

	@Autowired
	private StatutRdvRepository statutRdvRepository;

	@Override
	public StatutRdv add(StatutRdv statutRdv) {
		if (statutRdv != null)
			return statutRdvRepository.save(statutRdv);
		else
			return null;
	}

	@Override
	public Optional<StatutRdv> find(Integer id) {
		return statutRdvRepository.findById(id);
	}

	@Override
	public StatutRdv edit(StatutRdv statutRdv) {
		if (statutRdv != null)
			return statutRdvRepository.save(statutRdv);
		else
			return null;
	}

	@Override
	public void delete(Integer id) {
		if (statutRdvRepository.findById(id) != null)
			statutRdvRepository.deleteById(id);
	}

	@Override
	public List<StatutRdv> getAll() {
		try {
			List<StatutRdv> statutRdvs = statutRdvRepository.findAll();
			if (statutRdvs.isEmpty())
				return statutRdvs;
			else
				return Collections.emptyList();
		} catch (Exception e) {
			LOGGER.error("Erreur {} ", e);
			return Collections.emptyList();
		}
	}

}
