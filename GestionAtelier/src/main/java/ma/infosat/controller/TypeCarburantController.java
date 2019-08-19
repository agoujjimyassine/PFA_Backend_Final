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

import ma.infosat.model.TypeCarburant;
import ma.infosat.repository.TypeCarburantRepository;
import ma.infosat.service.TypeCarburantServiceI;


@CrossOrigin("*")
@RestController
public class TypeCarburantController {
	
	@Autowired
	private TypeCarburantServiceI typeCarburantService;

	@Autowired
	private TypeCarburantRepository typeCarburantRepository;
	
	public TypeCarburantController() {
	}
	
	@GetMapping(path="/typeCarburants")
	public Page<TypeCarburant> getAll(){
		return this.typeCarburantRepository.findAll(new PageRequest(0, 5));
		
	}
	
	@PostMapping(path="/typeCarburants")
	public TypeCarburant add(@RequestBody TypeCarburant typeCarburant) {
		return this.typeCarburantService.add(typeCarburant);
	}

	@PutMapping(path = "/typeCarburants")
	public TypeCarburant edit(@Valid @RequestBody TypeCarburant activite) {
		return this.typeCarburantService.edit(activite);
	}
	
	@GetMapping(path = "/typeCarburants/{id}")
	public Optional<TypeCarburant> getById(@PathVariable(value = "id") Integer id) {
		return this.typeCarburantService.find(id);
	}

	@DeleteMapping(path = "/typeCarburants/{id}")
	public void delete(@PathVariable(value = "id") Integer id) {
		this.typeCarburantService.delete(id);
	}
}
