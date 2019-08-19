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

import ma.infosat.model.Collaborateur;
import ma.infosat.repository.CollaborateurRepository;
import ma.infosat.service.CollaborateurServiceI;

@CrossOrigin("*")
@RestController
public class CollaborateurController {

	@Autowired
	private CollaborateurServiceI collaborateurService;

	@Autowired
	private CollaborateurRepository collaborateurRepository;

	public CollaborateurController() {
	}

	@GetMapping(path = "/collaborateurs")
	public Page<Collaborateur> getAll() {
		return this.collaborateurRepository.findAll(new PageRequest(0, 5));
	}

	@PostMapping(path = "/collaborateurs")
	public Collaborateur add(@RequestBody Collaborateur collaborateur) {
		return this.collaborateurService.add(collaborateur);
	}

	@PutMapping(path = "/collaborateurs")
	public Collaborateur edit(@Valid @RequestBody Collaborateur collaborateur) {
		return this.collaborateurService.edit(collaborateur);
	}

	@GetMapping(path = "/collaborateurs/{id}")
	public Optional<Collaborateur> getById(@PathVariable(value = "id") Integer id) {
		return this.collaborateurService.find(id);
	}
	
	@DeleteMapping(path = "/collaborateurs/{id}")
	public void delete(@PathVariable(value = "id") Integer id) {
		this.collaborateurService.delete(id);
	}
}
