package ma.infosat.controller;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ma.infosat.model.Contact;
import ma.infosat.repository.ContactRepository;
import ma.infosat.service.ContactServiceI;

@CrossOrigin("*")
@RestController
public class ContactController {
	
	@Autowired
	private ContactServiceI contactService;
	
	@Autowired
	private ContactRepository contactRepository;
	
	public ContactController() {
	}
	
	@GetMapping(path="/contacts")
	public Page<Contact> getAll(){
		return this.contactRepository.findAll(new PageRequest(0, 5));
	}
	
	@GetMapping(path="/contactsByIdClient/{id}")
	public List<Contact> getByIdDossier(@PathVariable(value = "id") Integer id){
		return this.contactService.getByIdClient(id);
	}
	
	@GetMapping(path="/contactsByIdExpert/{id}")
	public List<Contact> getByIdExpert(@PathVariable(value = "id") Integer id){
		return this.contactService.getByIdExpert(id);
	}
	
	@GetMapping(path="/contactsByIdAgenceAssurance/{id}")
	public List<Contact> getByIdAgenceAssurance(@PathVariable(value = "id") Integer id){
		return this.contactService.getByIdAgenceAssurance(id);
	}
	
	@PostMapping(path="/contacts")
	public Contact add(@RequestBody Contact contact){
		return this.contactService.add(contact);
	}
	
	@PutMapping(path = "/contacts")
	public Contact edit(@Valid @RequestBody Contact contact) {
		return this.contactService.edit(contact);
	}
	
	@GetMapping(path = "/contacts/{id}")
	public Optional<Contact> getById(@PathVariable(value = "id") Integer id) {
		return this.contactService.find(id);
	}
	
	@DeleteMapping(path = "/contacts/{id}")
	public void delete(@PathVariable(value = "id") Integer id) {
		this.contactService.delete(id);
	}
}
