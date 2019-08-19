package ma.infosat.service;

import java.util.List;
import java.util.Optional;

import ma.infosat.model.ContactDossier;

public interface ContactDossierServiceI {
	public ContactDossier add(ContactDossier contactDossier);

	public Optional<ContactDossier> find(Integer id);

	public ContactDossier edit(ContactDossier contactDossier);

	public void delete(Integer id);

	public List<ContactDossier> getAll();
	
	public List<ContactDossier> getByIdDossier(Integer id);
}
