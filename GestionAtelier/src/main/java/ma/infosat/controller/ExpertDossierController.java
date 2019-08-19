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

import ma.infosat.model.ExpertDossier;
import ma.infosat.repository.ExpertDossierRepository;
import ma.infosat.service.ExpertDossierServiceI;

@CrossOrigin("*")
@RestController
public class ExpertDossierController {
	
	@Autowired
	private ExpertDossierServiceI expertDossierService;
	
	@Autowired
	private ExpertDossierRepository expertDossierRepository;
	
	public ExpertDossierController() {
	}
	
	@GetMapping(path="/expertDossiers")
	public Page<ExpertDossier> getAll(){
		return this.expertDossierRepository.findAll(new PageRequest(0, 5));
	}
	
	@GetMapping(path="/expertDossiersByIdExpert/{id}")
	public List<ExpertDossier> getByIdExpert(@PathVariable(value = "id") Integer id){
		return this.expertDossierService.getByIdExpert(id);
	}
	
	@GetMapping(path="/expertDossiersByIdDossier/{id}")
	public List<ExpertDossier> getByIdDossier(@PathVariable(value = "id") Integer id){
		return this.expertDossierService.getByIdDossier(id);
	}

	
	@PostMapping(path="/expertDossiers")
	public ExpertDossier add(@RequestBody ExpertDossier expertDossier){
		return this.expertDossierService.add(expertDossier);
	}
	
	@PutMapping(path = "/expertDossiers")
	public ExpertDossier edit(@Valid @RequestBody ExpertDossier expertDossier) {
		return this.expertDossierService.edit(expertDossier);
	}
	
	@GetMapping(path = "/expertDossiers/{id}")
	public Optional<ExpertDossier> getById(@PathVariable(value = "id") Integer id) {
		return this.expertDossierService.find(id);
	}
	
	@DeleteMapping(path = "/expertDossiers/{id}")
	public void delete(@PathVariable(value = "id") Integer id) {
		this.expertDossierService.delete(id);
	}
}
