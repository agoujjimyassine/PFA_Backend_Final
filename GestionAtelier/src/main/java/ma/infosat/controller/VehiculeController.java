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

import ma.infosat.model.Vehicule;
import ma.infosat.repository.VehiculeRepository;
import ma.infosat.service.VehiculeServiceI;

@CrossOrigin("*")
@RestController
public class VehiculeController {
	
	@Autowired
	private VehiculeServiceI vehiculeService;

	@Autowired
	private VehiculeRepository vehiculeRepository;
	
	public VehiculeController() {
	}
	
	@GetMapping(path="/vehicules")
	public Page<Vehicule> getAll(){
		return this.vehiculeRepository.findAll(new PageRequest(0, 5));	
	}
	
	@PostMapping(path="/vehicules")
	public Vehicule add(@RequestBody Vehicule vehicule) {
		return this.vehiculeService.add(vehicule);
	}

	@PutMapping(path = "/vehicules")
	public Vehicule edit(@Valid @RequestBody Vehicule activite) {
		return this.vehiculeService.edit(activite);
	}
	
	@GetMapping(path = "/vehicules/{id}")
	public Optional<Vehicule> getById(@PathVariable(value = "id") Integer id) {
		return this.vehiculeService.find(id);
	}
	
	@DeleteMapping(path = "/vehicules/{id}")
	public void delete(@PathVariable(value = "id") Integer id) {
		this.vehiculeService.delete(id);
	}
}
