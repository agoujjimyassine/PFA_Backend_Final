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

import ma.infosat.model.CollaborateurRdv;
import ma.infosat.repository.CollaborateurRdvRepository;
import ma.infosat.service.CollaborateurRdvServiceI;

@CrossOrigin("*")
@RestController
public class CollaborateurRdvController {
	
	@Autowired
	private CollaborateurRdvServiceI collaborateurRdvService;
	
	@Autowired
	private CollaborateurRdvRepository collaborateurRdvRepository;
	
	public CollaborateurRdvController() {
	}
	
	@GetMapping(path="/collaborateurRdvs")
	public Page<CollaborateurRdv> getAll(){
		return this.collaborateurRdvRepository.findAll(new PageRequest(0, 5));
	}
	
	@GetMapping(path="/collaborateurRdvsByIdRendezVous/{id}")
	public List<CollaborateurRdv> getByIdRendezVous(@PathVariable(value = "id") Integer id){
		return this.collaborateurRdvService.getByIdRendezVous(id);
	}
	
	@PostMapping(path="/collaborateurRdvs")
	public CollaborateurRdv add(@RequestBody CollaborateurRdv collaborateurRdv){
		return this.collaborateurRdvService.add(collaborateurRdv);
	}
	
	@PutMapping(path = "/collaborateurRdvs")
	public CollaborateurRdv edit(@Valid @RequestBody CollaborateurRdv collaborateurRdv) {
		return this.collaborateurRdvService.edit(collaborateurRdv);
	}
	
	@GetMapping(path = "/collaborateurRdvs/{id}")
	public Optional<CollaborateurRdv> getById(@PathVariable(value = "id") Integer id) {
		return this.collaborateurRdvService.find(id);
	}
	
	@DeleteMapping(path = "/collaborateurRdvs/{id}")
	public void delete(@PathVariable(value = "id") Integer id) {
		this.collaborateurRdvService.delete(id);
	}
}
