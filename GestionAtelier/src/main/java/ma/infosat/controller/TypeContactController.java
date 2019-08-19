package ma.infosat.controller;

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

import ma.infosat.model.TypeContact;
import ma.infosat.repository.TypeContactRepository;
import ma.infosat.service.TypeContactServiceI;

@CrossOrigin("*")
@RestController
public class TypeContactController {
	
	@Autowired
	private TypeContactServiceI typeContactService;

	@Autowired
	private TypeContactRepository typeContactRepository;
	
	public TypeContactController() {
	}
	
	@GetMapping(path="/typeContacts")
	public Page<TypeContact> getAll(){
		return this.typeContactRepository.findAll(new PageRequest(0, 5));
		
	}
	
	@PostMapping(path="/typeContacts")
	public TypeContact add(@RequestBody TypeContact typeContact) {
		return this.typeContactService.add(typeContact);
	}

	@PutMapping(path = "/typeContacts")
	public TypeContact edit(@Valid @RequestBody TypeContact activite) {
		return this.typeContactService.edit(activite);
	}
	
	@GetMapping(path = "/typeContacts/{id}")
	public Optional<TypeContact> getById(@PathVariable(value = "id") Integer id) {
		return this.typeContactService.find(id);
	}
	
	@DeleteMapping(path = "/typeContacts/{id}")
	public void delete(@PathVariable(value = "id") Integer id) {
		this.typeContactService.delete(id);
	}
}
