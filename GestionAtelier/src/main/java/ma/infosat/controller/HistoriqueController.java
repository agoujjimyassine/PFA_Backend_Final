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

import ma.infosat.model.Historique;
import ma.infosat.repository.HistoriqueRepository;
import ma.infosat.service.HistoriqueServiceI;

@CrossOrigin("*")
@RestController
public class HistoriqueController {
	
	@Autowired
	private HistoriqueServiceI historiqueService;
	
	@Autowired
	private HistoriqueRepository historiqueRepository;
	
	public HistoriqueController() {
	}
	
	@GetMapping(path="/historiques")
	public Page<Historique> getAll(){
		return this.historiqueRepository.findAll(new PageRequest(0, 5));
	}
	
	@PostMapping(path="/historiques")
	public Historique add(@RequestBody Historique historique){
		return this.historiqueService.add(historique);
	}
	
	@PutMapping(path = "/historiques")
	public Historique edit(@Valid @RequestBody Historique historique) {
		return this.historiqueService.edit(historique);
	}
	
	@GetMapping(path = "/historiques/{id}")
	public Optional<Historique> getById(@PathVariable(value = "id") Integer id) {
		return this.historiqueService.find(id);
	}
	
	@DeleteMapping(path = "/historiques/{id}")
	public void delete(@PathVariable(value = "id") Integer id) {
		this.historiqueService.delete(id);
	}
}
