package ma.infosat.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.infosat.model.Fournisseur;
import ma.infosat.repository.FournisseurRepository;
import ma.infosat.service.FournisseurServiceI;

@Service
@Transactional
public class FournisseurServiceImpl implements FournisseurServiceI {

	private static final Logger LOGGER = LoggerFactory.getLogger(FournisseurServiceImpl.class);

	@Autowired
	private FournisseurRepository fournisseurRepository;

	@Override
	public Fournisseur add(Fournisseur fournisseur) {
		if (fournisseur != null)
			return fournisseurRepository.save(fournisseur);
		else
			return null;
	}

	@Override
	public Optional<Fournisseur> find(Integer id) {
		return fournisseurRepository.findById(id);
	}

	@Override
	public Fournisseur edit(Fournisseur fournisseur) {
		if (fournisseur != null)
			return fournisseurRepository.save(fournisseur);
		else
			return null;
	}

	@Override
	public void delete(Integer id) {
		if (fournisseurRepository.findById(id) != null)
			fournisseurRepository.deleteById(id);
	}

	@Override
	public List<Fournisseur> getAll() {
		try {
			List<Fournisseur> fournisseurs = fournisseurRepository.findAll();
			if (fournisseurs.isEmpty())
				return fournisseurs;
			else
				return Collections.emptyList();
		} catch (Exception e) {
			LOGGER.error("Erreur {} ", e);
			return Collections.emptyList();
		}
	}

}
