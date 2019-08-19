package ma.infosat.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.infosat.model.Dossier;
import ma.infosat.model.Fichier;
import ma.infosat.repository.FichierRepository;
import ma.infosat.service.DossierServiceI;
import ma.infosat.service.FichierServiceI;

@Service
@Transactional
public class FichierServiceImpl implements FichierServiceI {

	private static final Logger LOGGER = LoggerFactory.getLogger(FichierServiceImpl.class);

	@Autowired
	private FichierRepository fichierRepository;
	
	@Autowired
	private DossierServiceI dossierService;

	@Override
	public Fichier add(Fichier fichier) {
		if (fichier != null)
			return fichierRepository.save(fichier);
		else
			return null;
	}

	@Override
	public Optional<Fichier> find(Integer id) {
		return fichierRepository.findById(id);
	}

	@Override
	public Fichier edit(Fichier fichier) {
		if (fichier != null)
			return fichierRepository.save(fichier);
		else
			return null;
	}

	@Override
	public void delete(Integer id) {
		if (fichierRepository.findById(id) != null)
			fichierRepository.deleteById(id);
	}

	@Override
	public List<Fichier> getAll() {
		try {
			List<Fichier> fichiers = fichierRepository.findAll();
			if (fichiers.isEmpty())
				return fichiers;
			else
				return Collections.emptyList();
		} catch (Exception e) {
			LOGGER.error("Erreur {} ", e);
			return Collections.emptyList();
		}
	}

	@Override
	public List<Fichier> getByIdDossier(Integer id) {
		Optional<Dossier> dossier=dossierService.find(id);
		List<Fichier> fichiers=dossier.get().getFichiers();
		return fichiers;
	}

}
