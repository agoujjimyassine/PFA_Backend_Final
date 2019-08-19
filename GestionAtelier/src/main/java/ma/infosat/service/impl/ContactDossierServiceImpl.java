package ma.infosat.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.infosat.model.ContactDossier;
import ma.infosat.model.Dossier;
import ma.infosat.repository.ContactDossierRepository;
import ma.infosat.service.ContactDossierServiceI;
import ma.infosat.service.DossierServiceI;

@Service
@Transactional
public class ContactDossierServiceImpl implements ContactDossierServiceI {

	private static final Logger LOGGER = LoggerFactory.getLogger(ContactDossierServiceImpl.class);

	@Autowired
	private ContactDossierRepository contactDossierRepository;
	
	@Autowired
	private DossierServiceI dossierService;

	@Override
	public ContactDossier add(ContactDossier contactDossier) {
		if (contactDossier != null)
			return contactDossierRepository.save(contactDossier);
		else
			return null;
	}

	@Override
	public Optional<ContactDossier> find(Integer id) {
		return contactDossierRepository.findById(id);
	}

	@Override
	public ContactDossier edit(ContactDossier contactDossier) {
		if (contactDossier != null)
			return contactDossierRepository.save(contactDossier);
		else
			return null;
	}

	@Override
	public void delete(Integer id) {
		if (contactDossierRepository.findById(id) != null)
			contactDossierRepository.deleteById(id);
	}

	@Override
	public List<ContactDossier> getAll() {
		try {
			List<ContactDossier> contactDossiers = contactDossierRepository.findAll();
			if (contactDossiers.isEmpty())
				return contactDossiers;
			else
				return Collections.emptyList();
		} catch (Exception e) {
			LOGGER.error("Erreur {} ", e);
			return Collections.emptyList();
		}
	}

	@Override
	public List<ContactDossier> getByIdDossier(Integer id) {
		Optional<Dossier> dossier=dossierService.find(id);
		List<ContactDossier> contactDossiers=dossier.get().getContactDossiers();
		return contactDossiers;
	}

}
