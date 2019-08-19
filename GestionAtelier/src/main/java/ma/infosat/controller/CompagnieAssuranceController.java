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

import ma.infosat.model.CompagnieAssurance;
import ma.infosat.repository.CompagnieAssuranceRepository;
import ma.infosat.service.CompagnieAssuranceServiceI;

@CrossOrigin("*")
@RestController
public class CompagnieAssuranceController {

	@Autowired
	private CompagnieAssuranceServiceI compagnieAssuranceService;
	
	@Autowired
	private CompagnieAssuranceRepository compagnieAssuranceRepository;

	public CompagnieAssuranceController() {
	}

	@GetMapping(path = "/compagnieAssurances")
	public Page<CompagnieAssurance> getAll() {
		return this.compagnieAssuranceRepository.findAll(new PageRequest(0, 5));
	}

	@PostMapping(path = "/compagnieAssurances")
	public CompagnieAssurance add(@RequestBody CompagnieAssurance compagnieAssurance) {
		return this.compagnieAssuranceService.add(compagnieAssurance);
	}

	@PutMapping(path = "/compagnieAssurances")
	public CompagnieAssurance edit(@Valid @RequestBody CompagnieAssurance compagnieAssurance) {
		return this.compagnieAssuranceService.edit(compagnieAssurance);
	}

	@GetMapping(path = "/compagnieAssurances/{id}")
	public Optional<CompagnieAssurance> getById(@PathVariable(value = "id") Integer id) {
		return this.compagnieAssuranceService.find(id);
	}

	@DeleteMapping(path = "/compagnieAssurances/{id}")
	public void delete(@PathVariable(value = "id") Integer id) {
		this.compagnieAssuranceService.delete(id);
	}
}
