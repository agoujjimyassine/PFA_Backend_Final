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

import ma.infosat.model.Dossier;
import ma.infosat.repository.DossierRepository;
import ma.infosat.service.DossierServiceI;

@CrossOrigin("*")
@RestController
public class DossierController {
	
	@Autowired
	private DossierServiceI dossierService;
	
	@Autowired
	private DossierRepository dossierRepository;
	
	public DossierController() {
	}
	
	@GetMapping(path="/dossiersByIdAgenceAssurance/{id}")
	public List<Dossier> getByIdAgenceAssurance(@PathVariable(value = "id") Integer id){
		return this.dossierService.getByIdAgenceAssurance(id);
	}
	
	@GetMapping(path="/dossiers")
	public Page<Dossier> getAll(){
		return this.dossierRepository.findAll(new PageRequest(0, 5));
	}
	
	@PostMapping(path="/dossiers")
	public Dossier add(@RequestBody Dossier dossier){
		return this.dossierService.add(dossier);
	}
			
	@PutMapping(path = "/dossiers")
	public Dossier edit(@Valid @RequestBody Dossier dossier) {
		return this.dossierService.edit(dossier);
	}
	
	@GetMapping(path = "/dossiers/{id}")
	public Optional<Dossier> getById(@PathVariable(value = "id") Integer id) {
		return this.dossierService.find(id);
	}
	
	@DeleteMapping(path = "/dossiers/{id}")
	public void delete(@PathVariable(value = "id") Integer id) {
		this.dossierService.delete(id);
	}
}
