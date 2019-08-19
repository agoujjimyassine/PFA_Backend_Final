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
import ma.infosat.model.Client;
import ma.infosat.model.Contact;
import ma.infosat.model.Expert;
import ma.infosat.repository.ContactRepository;
import ma.infosat.service.AgenceAssuranceServiceI;
import ma.infosat.service.ClientServiceI;
import ma.infosat.service.ContactServiceI;
import ma.infosat.service.ExpertServiceI;

@Service
@Transactional
public class ContactServiceImpl implements ContactServiceI{

	private static final Logger LOGGER = LoggerFactory.getLogger(ContactServiceImpl.class);

	@Autowired
	private ContactRepository contactRepository;
	
	@Autowired
	private ClientServiceI clientService;
	
	@Autowired
	private ExpertServiceI expertService;

	@Autowired
	private AgenceAssuranceServiceI agenceAssuranceService;
	
	@Override
	public Contact add(Contact contact) {
		if (contact != null)
			return contactRepository.save(contact);
		else
			return null;
	}

	@Override
	public Optional<Contact> find(Integer id) {
		return contactRepository.findById(id);
	}

	@Override
	public Contact edit(Contact contact) {
		if (contact != null)
			return contactRepository.save(contact);
		else
			return null;
	}

	@Override
	public void delete(Integer id) {
		if (contactRepository.findById(id) != null)
			contactRepository.deleteById(id);
	}

	@Override
	public List<Contact> getAll() {
		try {
			List<Contact> contacts = contactRepository.findAll();
			if (contacts.isEmpty())
				return contacts;
			else
				return Collections.emptyList();
		} catch (Exception e) {
			LOGGER.error("Erreur {} ", e);
			return Collections.emptyList();
		}
	}

	@Override
	public List<Contact> getByIdClient(Integer id) {
		Optional<Client> client=clientService.find(id);
		List<Contact> contacts=client.get().getContacts();
		return contacts;
	}

	@Override
	public List<Contact> getByIdExpert(Integer id) {
		Optional<Expert> expert=expertService.find(id);
		List<Contact> contacts=expert.get().getContacts();
		return contacts;
	}

	@Override
	public List<Contact> getByIdAgenceAssurance(Integer id) {
		Optional<AgenceAssurance> agenceAssurance=agenceAssuranceService.find(id);
		List<Contact> contacts=agenceAssurance.get().getContacts();
		return contacts;
	}

}
