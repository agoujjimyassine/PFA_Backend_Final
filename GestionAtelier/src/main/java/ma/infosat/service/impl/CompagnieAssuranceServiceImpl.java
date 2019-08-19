package ma.infosat.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.infosat.model.CompagnieAssurance;
import ma.infosat.repository.CompagnieAssuranceRepository;
import ma.infosat.service.CompagnieAssuranceServiceI;

@Service
@Transactional
public class CompagnieAssuranceServiceImpl implements CompagnieAssuranceServiceI {

	private static final Logger LOGGER = LoggerFactory.getLogger(CompagnieAssuranceServiceImpl.class);

	@Autowired
	private CompagnieAssuranceRepository compagnieAssuranceRepository;

	@Override
	public CompagnieAssurance add(CompagnieAssurance compagnieAssurance) {
		if (compagnieAssurance != null)
			return compagnieAssuranceRepository.save(compagnieAssurance);
		else
			return null;
	}

	@Override
	public Optional<CompagnieAssurance> find(Integer id) {
		return compagnieAssuranceRepository.findById(id);

	}

	@Override
	public CompagnieAssurance edit(CompagnieAssurance compagnieAssurance) {
		if (compagnieAssurance != null)
			return compagnieAssuranceRepository.save(compagnieAssurance);
		else
			return null;
	}

	@Override
	public void delete(Integer id) {
		if (compagnieAssuranceRepository.findById(id) != null)
			compagnieAssuranceRepository.deleteById(id);
	}

	@Override
	public List<CompagnieAssurance> getAll() {
		try {
			List<CompagnieAssurance> compagnieAssurances = compagnieAssuranceRepository.findAll();
			if (compagnieAssurances.isEmpty())
				return compagnieAssurances;
			else
				return Collections.emptyList();
		} catch (Exception e) {
			LOGGER.error("Erreur {} ", e);
			return Collections.emptyList();
		}
	}

}