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

import ma.infosat.model.AgenceAssurance;
import ma.infosat.repository.AgenceAssuranceRepository;
import ma.infosat.service.AgenceAssuranceServiceI;

@CrossOrigin("*")
@RestController
public class AgenceAssuranceController {
	
	@Autowired
	private AgenceAssuranceServiceI agenceAssuranceService;
	
	@Autowired
	private AgenceAssuranceRepository agenceAssuranceRepository;
	
	public AgenceAssuranceController() {
	}
	
	@GetMapping(path="/agencesAssurancesByIdCompagnieAssurance/{id}")
	public List<AgenceAssurance> getByIdCompagnieAssurance(@PathVariable(value = "id") Integer id){
		return this.agenceAssuranceService.geByIdCompagnieAssurance(id);
	}
	
	@GetMapping(path="/agenceAssurances")
	public Page<AgenceAssurance> getAll(){
		return this.agenceAssuranceRepository.findAll(new PageRequest(0, 5));
	}
	
	@PostMapping(path="/agenceAssurances")
	public AgenceAssurance add(@RequestBody AgenceAssurance agenceAssurance){
		return this.agenceAssuranceService.add(agenceAssurance);
	}
	
	@PutMapping(path = "/agenceAssurances")
	public AgenceAssurance edit(@Valid @RequestBody AgenceAssurance agenceAssurance) {
		return this.agenceAssuranceService.edit(agenceAssurance);
	}
	
	@GetMapping(path = "/agenceAssurances/{id}")
	public Optional<AgenceAssurance> getById(@PathVariable(value = "id") Integer id) {
		return this.agenceAssuranceService.find(id);
	}
	
	@DeleteMapping(path = "/agenceAssurances/{id}")
	public void delete(@PathVariable(value = "id") Integer id) {
		this.agenceAssuranceService.delete(id);
	}
}
