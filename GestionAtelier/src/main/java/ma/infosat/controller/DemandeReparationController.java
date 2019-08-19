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

import ma.infosat.model.DemandeReparation;
import ma.infosat.repository.DemandeReparationRepository;
import ma.infosat.service.DemandeReparationServiceI;

@CrossOrigin("*")
@RestController
public class DemandeReparationController {

	@Autowired
	private DemandeReparationServiceI demandeReparationService;
	
	@Autowired
	private DemandeReparationRepository demandeReparationRepository;
	
	public DemandeReparationController() {
	}
	
	@GetMapping(path="/demandeReparations")
	public Page<DemandeReparation> getAll(){
		return this.demandeReparationRepository.findAll(new PageRequest(0, 5));
	}
	
	@PostMapping(path="/demandeReparations")
	public DemandeReparation add(@RequestBody DemandeReparation demandeReparation){
		return this.demandeReparationService.add(demandeReparation);
	}
	
	@PutMapping(path = "/demandeReparations")
	public DemandeReparation edit(@Valid @RequestBody DemandeReparation demandeReparation) {
		return this.demandeReparationService.edit(demandeReparation);
	}
	
	@GetMapping(path = "/demandeReparations/{id}")
	public Optional<DemandeReparation> getById(@PathVariable(value = "id") Integer id) {
		return this.demandeReparationService.find(id);
	}
		
	@DeleteMapping(path = "/demandeReparations/{id}")
	public void delete(@PathVariable(value = "id") Integer id) {
		this.demandeReparationService.delete(id);
	}
}
