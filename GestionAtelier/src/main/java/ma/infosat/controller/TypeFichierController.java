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

import ma.infosat.model.TypeFichier;
import ma.infosat.repository.TypeFichierRepository;
import ma.infosat.service.TypeFichierServiceI;

@CrossOrigin("*")
@RestController
public class TypeFichierController {
	
	@Autowired
	private TypeFichierServiceI typeFichierService;

	@Autowired
	private TypeFichierRepository typeFichierRepository;
	
	public TypeFichierController() {
	}
	
	@GetMapping(path="/typeFichiers")
	public Page<TypeFichier> getAll(){
		return this.typeFichierRepository.findAll(new PageRequest(0, 5));
		
	}
	
	@PostMapping(path="/typeFichiers")
	public TypeFichier add(@RequestBody TypeFichier typeFichier) {
		return this.typeFichierService.add(typeFichier);
	}

	@PutMapping(path = "/typeFichiers")
	public TypeFichier edit(@Valid @RequestBody TypeFichier activite) {
		return this.typeFichierService.edit(activite);
	}
	
	@GetMapping(path = "/typeFichiers/{id}")
	public Optional<TypeFichier> getById(@PathVariable(value = "id") Integer id) {
		return this.typeFichierService.find(id);
	}
	
	@DeleteMapping(path = "/typeFichiers/{id}")
	public void delete(@PathVariable(value = "id") Integer id) {
		this.typeFichierService.delete(id);
	}
}
