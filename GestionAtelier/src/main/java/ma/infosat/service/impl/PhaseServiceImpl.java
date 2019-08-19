package ma.infosat.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.infosat.model.Phase;
import ma.infosat.repository.PhaseRepository;
import ma.infosat.service.PhaseServiceI;

@Service
@Transactional
public class PhaseServiceImpl implements PhaseServiceI {

	private static final Logger LOGGER = LoggerFactory.getLogger(PhaseServiceImpl.class);

	@Autowired
	private PhaseRepository phaseRepository;

	@Override
	public Phase add(Phase phase) {
		if (phase != null)
			return phaseRepository.save(phase);
		else
			return null;
	}

	@Override
	public Optional<Phase> find(Integer id) {
		return phaseRepository.findById(id);
	}

	@Override
	public Phase edit(Phase phase) {
		if (phase != null)
			return phaseRepository.save(phase);
		else
			return null;
	}

	@Override
	public void delete(Integer id) {
		if (phaseRepository.findById(id) != null)
			phaseRepository.deleteById(id);
	}

	@Override
	public List<Phase> getAll() {
		try {
			List<Phase> phases = phaseRepository.findAll();
			if (phases.isEmpty())
				return phases;
			else
				return Collections.emptyList();
		} catch (Exception e) {
			LOGGER.error("Erreur {} ", e);
			return Collections.emptyList();
		}
	}

}
