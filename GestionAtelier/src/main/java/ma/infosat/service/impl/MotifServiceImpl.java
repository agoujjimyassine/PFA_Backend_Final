package ma.infosat.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.infosat.model.Motif;
import ma.infosat.repository.MotifRepository;
import ma.infosat.service.MotifServiceI;

@Service
@Transactional
public class MotifServiceImpl implements MotifServiceI {

	private static final Logger LOGGER = LoggerFactory.getLogger(MotifServiceImpl.class);

	@Autowired
	private MotifRepository motifRepository;

	@Override
	public Motif add(Motif motif) {
		if (motif != null)
			return motifRepository.save(motif);
		else
			return null;
	}

	@Override
	public Optional<Motif> find(Integer id) {
		return motifRepository.findById(id);
	}

	@Override
	public Motif edit(Motif motif) {
		if (motif != null)
			return motifRepository.save(motif);
		else
			return null;
	}

	@Override
	public void delete(Integer id) {
		if (motifRepository.findById(id) != null)
			motifRepository.deleteById(id);
	}

	@Override
	public List<Motif> getAll() {
		try {
			List<Motif> motifs = motifRepository.findAll();
			if (motifs.isEmpty())
				return motifs;
			else
				return Collections.emptyList();
		} catch (Exception e) {
			LOGGER.error("Erreur {} ", e);
			return Collections.emptyList();
		}
	}

}
