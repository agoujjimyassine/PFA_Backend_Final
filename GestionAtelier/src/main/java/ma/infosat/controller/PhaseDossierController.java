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

import ma.infosat.model.PhaseDossier;
import ma.infosat.repository.PhaseDossierRepository;
import ma.infosat.service.PhaseDossierServiceI;


@CrossOrigin("*")
@RestController
public class PhaseDossierController {
	
	@Autowired
	private PhaseDossierServiceI phaseDossierService;
	
	@Autowired
	private PhaseDossierRepository phaseDossierRepository;

	public PhaseDossierController() {
	}
	
	@GetMapping(path="/phaseDossiers")
	public Page<PhaseDossier> getAll(){
		return this.phaseDossierRepository.findAll(new PageRequest(0, 5));	
	}
	
	@GetMapping(path="/phaseDossiersByIdDossier/{id}")
	public List<PhaseDossier> getByIdDossier(@PathVariable(value = "id") Integer id){
		return this.phaseDossierService.getByIdDossier(id);
	}
	
	@PostMapping(path="/phaseDossiers")
	public PhaseDossier add(@RequestBody PhaseDossier phaseDossier) {
		return this.phaseDossierService.add(phaseDossier);
	}

	@PutMapping(path = "/phaseDossiers")
	public PhaseDossier edit(@Valid @RequestBody PhaseDossier activite) {
		return this.phaseDossierService.edit(activite);
	}
	
	@GetMapping(path = "/phaseDossiers/{id}")
	public Optional<PhaseDossier> getById(@PathVariable(value = "id") Integer id) {
		return this.phaseDossierService.find(id);
	}
	
	@DeleteMapping(path = "/phaseDossiers/{id}")
	public void delete(@PathVariable(value = "id") Integer id) {
		this.phaseDossierService.delete(id);
	}
}
