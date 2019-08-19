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

import ma.infosat.model.Commande;
import ma.infosat.repository.CommandeRepository;
import ma.infosat.service.CommandeServiceI;

@CrossOrigin("*")
@RestController
public class CommandeController {

	@Autowired
	private CommandeServiceI commandeService;
	
	@Autowired
	private CommandeRepository commandeRepository;
	
	public CommandeController() {
	}
	
	@GetMapping(path="/commandes")
	public Page<Commande> getAll(){
		return this.commandeRepository.findAll(new PageRequest(0, 5));
	}
	
	@GetMapping(path="/commandesByIdFournisseur/{id}")
	public List<Commande> getByIdFournisseur(@PathVariable(value = "id") Integer id){
		return this.commandeService.getByIdFournisseur(id);
	}
	
	@PostMapping(path="/commandes")
	public Commande add(@RequestBody Commande commande){
		return this.commandeService.add(commande);
	}
	
	@PutMapping(path = "/commandes")
	public Commande edit(@Valid @RequestBody Commande commande) {
		return this.commandeService.edit(commande);
	}
	
	@GetMapping(path = "/commandes/{id}")
	public Optional<Commande> getById(@PathVariable(value = "id") Integer id) {
		return this.commandeService.find(id);
	}
		
	@DeleteMapping(path = "/commandes/{id}")
	public void delete(@PathVariable(value = "id") Integer id) {
		this.commandeService.delete(id);
	}
	
}
