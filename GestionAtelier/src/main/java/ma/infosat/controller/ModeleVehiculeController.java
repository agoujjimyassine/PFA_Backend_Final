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

import ma.infosat.model.ModeleVehicule;
import ma.infosat.repository.ModeleVehiculeRepository;
import ma.infosat.service.ModeleVehiculeServiceI;


@CrossOrigin("*")
@RestController
public class ModeleVehiculeController {
	
	@Autowired
	private ModeleVehiculeServiceI modeleVehiculeService;
	
	@Autowired
	private ModeleVehiculeRepository modeleVehiculeRepository;
	
	public ModeleVehiculeController() {
		
	}
	@GetMapping(path="/modeleVehicules")
	public Page<ModeleVehicule> getAll(){
		return this.modeleVehiculeRepository.findAll(new PageRequest(0, 5));
		
	}
	
	@PostMapping(path="/modeleVehicules")
	public ModeleVehicule add(@RequestBody ModeleVehicule modeleVehicule) {
		return this.modeleVehiculeService.add(modeleVehicule);
	}

	@PutMapping(path = "/modeleVehicules")
	public ModeleVehicule edit(@Valid @RequestBody ModeleVehicule activite) {
		return this.modeleVehiculeService.edit(activite);
	}
	
	@GetMapping(path = "/modeleVehicules/{id}")
	public Optional<ModeleVehicule> getById(@PathVariable(value = "id") Integer id) {
		return this.modeleVehiculeService.find(id);
	}
	
	@DeleteMapping(path = "/modeleVehicules/{id}")
	public void delete(@PathVariable(value = "id") Integer id) {
		this.modeleVehiculeService.delete(id);
	}
}
