package ma.infosat.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.infosat.model.AgenceAssurance;
import ma.infosat.model.CompagnieAssurance;
import ma.infosat.repository.AgenceAssuranceRepository;
import ma.infosat.service.AgenceAssuranceServiceI;
import ma.infosat.service.CompagnieAssuranceServiceI;

@Service
@Transactional
public class AgenceAssuranceServiceImpl implements AgenceAssuranceServiceI {

	private static final Logger LOGGER = LoggerFactory.getLogger(AgenceAssuranceServiceImpl.class);

	@Autowired
	private AgenceAssuranceRepository agenceAssuranceRepository;

	@Autowired
	private CompagnieAssuranceServiceI compagnieAssuranceService;
	
	@Override
	public AgenceAssurance add(AgenceAssurance agenceAssurance) {
		if (agenceAssurance != null)
			return agenceAssuranceRepository.save(agenceAssurance);
		else
			return null;
	}

	@Override
	public Optional<AgenceAssurance> find(Integer id) {
		return agenceAssuranceRepository.findById(id);
	}

	@Override
	public AgenceAssurance edit(AgenceAssurance agenceAssurance) {
		if (agenceAssurance != null)
			return agenceAssuranceRepository.save(agenceAssurance);
		else
			return null;
	}

	@Override
	public void delete(Integer id) {
		if (agenceAssuranceRepository.findById(id) != null)
			agenceAssuranceRepository.deleteById(id);
	}

	@Override
	public List<AgenceAssurance> getAll() {
		try {
			List<AgenceAssurance> agenceAssurances = agenceAssuranceRepository.findAll();
			if (agenceAssurances.isEmpty())
				return agenceAssurances;
			else
				return Collections.emptyList();
		} catch (Exception e) {
			LOGGER.error("Erreur {} ", e);
			return Collections.emptyList();
		}
	}

	@Override
	public List<AgenceAssurance> geByIdCompagnieAssurance(Integer id) {
		Optional<CompagnieAssurance> compagnieAssurance=compagnieAssuranceService.find(id);
		List<AgenceAssurance> agenceAssurances=compagnieAssurance.get().getAgenceAssurance();
		return agenceAssurances;
	}

}
