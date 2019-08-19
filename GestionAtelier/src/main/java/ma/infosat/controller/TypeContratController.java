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

import ma.infosat.model.TypeContrat;
import ma.infosat.repository.TypeContratRepository;
import ma.infosat.service.TypeContratServiceI;

@CrossOrigin("*")
@RestController
public class TypeContratController {
	
	@Autowired
	private TypeContratServiceI typeContratService;
	
	@Autowired
	private TypeContratRepository TypeContratRepository;
	
	@GetMapping(path="/typeContrats")
	public Page<TypeContrat> getAll(){
		return this.TypeContratRepository.findAll(new PageRequest(0, 5));
		
	}
	
	@PostMapping(path="/typeContrats")
	public TypeContrat add(@RequestBody TypeContrat typeContrat) {
		return this.typeContratService.add(typeContrat);
	}

	@PutMapping(path = "/typeContrats")
	public TypeContrat edit(@Valid @RequestBody TypeContrat activite) {
		return this.typeContratService.edit(activite);
	}
	
	@GetMapping(path = "/typeContrats/{id}")
	public Optional<TypeContrat> getById(@PathVariable(value = "id") Integer id) {
		return this.typeContratService.find(id);
	}
	
	@DeleteMapping(path = "/typeContrats/{id}")
	public void delete(@PathVariable(value = "id") Integer id) {
		this.typeContratService.delete(id);
	}
}
