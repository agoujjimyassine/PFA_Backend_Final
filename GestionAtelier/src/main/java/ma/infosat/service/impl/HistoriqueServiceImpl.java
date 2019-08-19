package ma.infosat.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.infosat.model.Historique;
import ma.infosat.repository.HistoriqueRepository;
import ma.infosat.service.HistoriqueServiceI;

@Service
@Transactional
public class HistoriqueServiceImpl implements HistoriqueServiceI {

	private static final Logger LOGGER = LoggerFactory.getLogger(HistoriqueServiceImpl.class);

	@Autowired
	private HistoriqueRepository historiqueRepository;

	@Override
	public Historique add(Historique historique) {
		if (historique != null)
			return historiqueRepository.save(historique);
		else
			return null;
	}

	@Override
	public Optional<Historique> find(Integer id) {
		return historiqueRepository.findById(id);
	}

	@Override
	public Historique edit(Historique historique) {
		if (historique != null)
			return historiqueRepository.save(historique);
		else
			return null;
	}

	@Override
	public void delete(Integer id) {
		if (historiqueRepository.findById(id) != null)
			historiqueRepository.deleteById(id);
	}

	@Override
	public List<Historique> getAll() {
		try {
			List<Historique> historiques = historiqueRepository.findAll();
			if (historiques.isEmpty())
				return historiques;
			else
				return Collections.emptyList();
		} catch (Exception e) {
			LOGGER.error("Erreur {} ", e);
			return Collections.emptyList();
		}
	}

}
