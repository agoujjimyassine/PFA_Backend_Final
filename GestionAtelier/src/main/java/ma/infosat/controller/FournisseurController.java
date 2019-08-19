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

import ma.infosat.model.Fournisseur;
import ma.infosat.repository.FournisseurRepository;
import ma.infosat.service.FournisseurServiceI;

@CrossOrigin("*")
@RestController
public class FournisseurController {
	
	@Autowired
	private FournisseurServiceI fournisseurService;
	
	@Autowired
	private FournisseurRepository fournisseurRepository;
	
	public FournisseurController() {
	}
	
	@GetMapping(path="/fournisseurs")
	public Page<Fournisseur> getAll(){
		return this.fournisseurRepository.findAll(new PageRequest(0, 5));
	}
	
	@PostMapping(path="/fournisseurs")
	public Fournisseur add(@RequestBody Fournisseur fournisseur){
		return this.fournisseurService.add(fournisseur);
	}
	
	@PutMapping(path = "/fournisseurs")
	public Fournisseur edit(@Valid @RequestBody Fournisseur fournisseur) {
		return this.fournisseurService.edit(fournisseur);
	}
	
	@GetMapping(path = "/fournisseurs/{id}")
	public Optional<Fournisseur> getById(@PathVariable(value = "id") Integer id) {
		return this.fournisseurService.find(id);
	}
	
	@DeleteMapping(path = "/fournisseurs/{id}")
	public void delete(@PathVariable(value = "id") Integer id) {
		this.fournisseurService.delete(id);
	}
}
