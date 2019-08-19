package ma.infosat.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.infosat.model.PuissanceFiscale;
import ma.infosat.repository.PuissanceFiscaleRepository;
import ma.infosat.service.PuissanceFiscaleServiceI;

@Service
@Transactional
public class PuissanceFiscaleServiceImpl implements PuissanceFiscaleServiceI {

	private static final Logger LOGGER = LoggerFactory.getLogger(PuissanceFiscaleServiceImpl.class);

	@Autowired
	private PuissanceFiscaleRepository puissanceFiscaleRepository;

	@Override
	public PuissanceFiscale add(PuissanceFiscale puissanceFiscale) {
		if (puissanceFiscale != null)
			return puissanceFiscaleRepository.save(puissanceFiscale);
		else
			return null;
	}

	@Override
	public Optional<PuissanceFiscale> find(Integer id) {
		return puissanceFiscaleRepository.findById(id);
	}

	@Override
	public PuissanceFiscale edit(PuissanceFiscale puissanceFiscale) {
		if (puissanceFiscale != null)
			return puissanceFiscaleRepository.save(puissanceFiscale);
		else
			return null;
	}

	@Override
	public void delete(Integer id) {
		if (puissanceFiscaleRepository.findById(id) != null)
			puissanceFiscaleRepository.deleteById(id);
	}

	@Override
	public List<PuissanceFiscale> getAll() {
		try {
			List<PuissanceFiscale> puissanceFiscales = puissanceFiscaleRepository.findAll();
			if (puissanceFiscales.isEmpty())
				return puissanceFiscales;
			else
				return Collections.emptyList();
		} catch (Exception e) {
			LOGGER.error("Erreur {} ", e);
			return Collections.emptyList();
		}
	}

}
