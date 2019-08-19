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

import ma.infosat.model.MarqueVehicule;
import ma.infosat.repository.MarqueVehiculeRepository;
import ma.infosat.service.MarqueVehiculeServiceI;

@CrossOrigin("*")
@RestController
public class MarqueVehiculeController {
	
	@Autowired
	private MarqueVehiculeServiceI marqueVehiculeService;
	
	@Autowired
	private MarqueVehiculeRepository marqueVehiculeRepository;
	
	public MarqueVehiculeController() {
	}
	
	@GetMapping(path="/marqueVehicules")
	public Page<MarqueVehicule> getAll(){
		return this.marqueVehiculeRepository.findAll(new PageRequest(0, 5));
	}
	
	@PostMapping(path="/marqueVehicules")
	public MarqueVehicule add(@RequestBody MarqueVehicule marqueVehicule){
		return this.marqueVehiculeService.add(marqueVehicule);
	}
	
	@PutMapping(path = "/marqueVehicules")
	public MarqueVehicule edit(@Valid @RequestBody MarqueVehicule marqueVehicule) {
		return this.marqueVehiculeService.edit(marqueVehicule);
	}
	
	@GetMapping(path = "/marqueVehicules/{id}")
	public Optional<MarqueVehicule> getById(@PathVariable(value = "id") Integer id) {
		return this.marqueVehiculeService.find(id);
	}
	
	@DeleteMapping(path = "/marqueVehicules/{id}")
	public void delete(@PathVariable(value = "id") Integer id) {
		this.marqueVehiculeService.delete(id);
	}
}
