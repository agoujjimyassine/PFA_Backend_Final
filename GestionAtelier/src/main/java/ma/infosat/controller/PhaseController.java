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

import ma.infosat.model.Phase;
import ma.infosat.repository.PhaseRepository;
import ma.infosat.service.PhaseServiceI;
@CrossOrigin("*")
@RestController
public class PhaseController {
	
	@Autowired
	private PhaseServiceI phaseService;
	
	@Autowired
	private PhaseRepository phaseRepository;

	public PhaseController() {
	}
	
	@GetMapping(path="/phases")
	public Page<Phase> getAll(){
		return this.phaseRepository.findAll(new PageRequest(0, 5));	
	}
	
	@PostMapping(path="/phases")
	public Phase add(@RequestBody Phase phase) {
		return this.phaseService.add(phase);
	}

	@PutMapping(path = "/phases")
	public Phase edit(@Valid @RequestBody Phase activite) {
		return this.phaseService.edit(activite);
	}
	
	@GetMapping(path = "/phases/{id}")
	public Optional<Phase> getById(@PathVariable(value = "id") Integer id) {
		return this.phaseService.find(id);
	}
	
	@DeleteMapping(path = "/phases/{id}")
	public void delete(@PathVariable(value = "id") Integer id) {
		this.phaseService.delete(id);
	}
}
