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

import ma.infosat.model.Fichier;
import ma.infosat.repository.FichierRepository;
import ma.infosat.service.FichierServiceI;

@CrossOrigin("*")
@RestController
public class FichierController {
	
	@Autowired
	private FichierServiceI fichierService;
	
	@Autowired
	private FichierRepository fichierRepository;
	
	public FichierController() {
	}
	
	@GetMapping(path="/fichiers")
	public Page<Fichier> getAll(){
		return this.fichierRepository.findAll(new PageRequest(0, 5));
	}
	
	@GetMapping(path="/fichiersByIdDossier/{id}")
	public List<Fichier> getByIdDossier(@PathVariable(value = "id") Integer id){
		return this.fichierService.getByIdDossier(id);
	}
	
	@PostMapping(path="/fichiers")
	public Fichier add(@RequestBody Fichier fichier){
		return this.fichierService.add(fichier);
	}
	
	@PutMapping(path = "/fichiers")
	public Fichier edit(@Valid @RequestBody Fichier fichier) {
		return this.fichierService.edit(fichier);
	}
	
	@GetMapping(path = "/fichiers/{id}")
	public Optional<Fichier> getById(@PathVariable(value = "id") Integer id) {
		return this.fichierService.find(id);
	}
	
	@DeleteMapping(path = "/fichiers/{id}")
	public void delete(@PathVariable(value = "id") Integer id) {
		this.fichierService.delete(id);
	}
}
