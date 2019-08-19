package ma.infosat.service;

import java.util.List;
import java.util.Optional;

import ma.infosat.model.Contact;

public interface ContactServiceI {
	public Contact add(Contact contact);

	public Optional<Contact> find(Integer id);

	public Contact edit(Contact contact);

	public void delete(Integer id);

	public List<Contact> getAll();
	
	public List<Contact> getByIdClient(Integer id);
	
	public List<Contact> getByIdExpert(Integer id);
	
	public List<Contact> getByIdAgenceAssurance(Integer id);
}
