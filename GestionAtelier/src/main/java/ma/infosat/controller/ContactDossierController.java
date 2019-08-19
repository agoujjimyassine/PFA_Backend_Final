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

import ma.infosat.model.ContactDossier;
import ma.infosat.model.Fichier;
import ma.infosat.repository.ContactDossierRepository;
import ma.infosat.service.ContactDossierServiceI;

@CrossOrigin("*")
@RestController
public class ContactDossierController {
	
	@Autowired
	private ContactDossierServiceI contactDossierService;
	
	@Autowired
	private ContactDossierRepository contactDossierRepository;
	
	public ContactDossierController() {
	}
	
	@GetMapping(path="/contactDossiers")
	public Page<ContactDossier> getAll(){
		return this.contactDossierRepository.findAll(new PageRequest(0, 5));
	}
	
	@GetMapping(path="/contactDossiersByIdDossier/{id}")
	public List<ContactDossier> getByIdDossier(@PathVariable(value = "id") Integer id){
		return this.contactDossierService.getByIdDossier(id);
	}

	
	@PostMapping(path="/contactDossiers")
	public ContactDossier add(@RequestBody ContactDossier contactDossier){
		return this.contactDossierService.add(contactDossier);
	}
	
	@PutMapping(path = "/contactDossiers")
	public ContactDossier edit(@Valid @RequestBody ContactDossier contactDossier) {
		return this.contactDossierService.edit(contactDossier);
	}
	
	@GetMapping(path = "/contactDossiers/{id}")
	public Optional<ContactDossier> getById(@PathVariable(value = "id") Integer id) {
		return this.contactDossierService.find(id);
	}
	
	@DeleteMapping(path = "/contactDossiers/{id}")
	public void delete(@PathVariable(value = "id") Integer id) {
		this.contactDossierService.delete(id);
	}
}
