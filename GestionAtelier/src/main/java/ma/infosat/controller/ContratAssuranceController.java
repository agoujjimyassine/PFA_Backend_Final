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

import ma.infosat.model.ContratAssurance;
import ma.infosat.repository.ContratAssuranceRepository;
import ma.infosat.service.ContratAssuranceServiceI;

@CrossOrigin("*")
@RestController
public class ContratAssuranceController {
	
	@Autowired
	private ContratAssuranceServiceI contratAssuranceService;
	
	@Autowired
	private ContratAssuranceRepository contratAssuranceRepository;
	
	public ContratAssuranceController() {
	}
	
	@GetMapping(path="/contratAssurances")
	public Page<ContratAssurance> getAll(){
		return this.contratAssuranceRepository.findAll(new PageRequest(0, 5));
	}
	
	@GetMapping(path="/contratAssurancesByIdDossier/{id}")
	public List<ContratAssurance> getByIdDossier(@PathVariable(value = "id") Integer id){
		return this.contratAssuranceService.getByIdDossier(id);
	}
	
	@PostMapping(path="/contratAssurances")
	public ContratAssurance add(@RequestBody ContratAssurance contratAssurance){
		return this.contratAssuranceService.add(contratAssurance);
	}
	
	@PutMapping(path = "/contratAssurances")
	public ContratAssurance edit(@Valid @RequestBody ContratAssurance contratAssurance) {
		return this.contratAssuranceService.edit(contratAssurance);
	}
	
	@GetMapping(path = "/contratAssurances/{id}")
	public Optional<ContratAssurance> getById(@PathVariable(value = "id") Integer id) {
		return this.contratAssuranceService.find(id);
	}
	
	@DeleteMapping(path = "/contratAssurances/{id}")
	public void delete(@PathVariable(value = "id") Integer id) {
		this.contratAssuranceService.delete(id);
	}
}
