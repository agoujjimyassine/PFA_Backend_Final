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

import ma.infosat.model.Tache;
import ma.infosat.repository.TacheRepository;
import ma.infosat.service.TacheServiceI;

@CrossOrigin("*")
@RestController
public class TacheController {

	@Autowired
	private TacheServiceI tacheService;
	
	@Autowired
	private TacheRepository tacheRepository;
	
	public TacheController() {
	}
	
	@GetMapping(path="/taches")
	public Page<Tache> getAll(){
		return this.tacheRepository.findAll(new PageRequest(0, 5));
	}
	
	@GetMapping(path="/tachesByIdDemandeReparation/{id}")
	public List<Tache> getByIdDemandeReparation(@PathVariable(value = "id") Integer id){
		return this.tacheService.getByIdDemandeReparation(id);
	}
	
	@PostMapping(path="/taches")
	public Tache add(@RequestBody Tache tache){
		return this.tacheService.add(tache);
	}
	
	@PutMapping(path = "/taches")
	public Tache edit(@Valid @RequestBody Tache tache) {
		return this.tacheService.edit(tache);
	}
	
	@GetMapping(path = "/taches/{id}")
	public Optional<Tache> getById(@PathVariable(value = "id") Integer id) {
		return this.tacheService.find(id);
	}
		
	@DeleteMapping(path = "/taches/{id}")
	public void delete(@PathVariable(value = "id") Integer id) {
		this.tacheService.delete(id);
	}

}
