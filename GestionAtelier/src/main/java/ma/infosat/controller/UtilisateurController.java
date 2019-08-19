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

import ma.infosat.model.Utilisateur;
import ma.infosat.repository.UtilisateurRepository;
import ma.infosat.service.UtilisateurServiceI;

@CrossOrigin("*")
@RestController
public class UtilisateurController {
	
	@Autowired
	private UtilisateurServiceI utilisateurService;
	
	@Autowired
	private UtilisateurRepository UtilisateurRepository;
	
	@GetMapping(path="/utilisateurs")
	public Page<Utilisateur> getAll(){
		return this.UtilisateurRepository.findAll(new PageRequest(0, 5));
		
	}
	
	@PostMapping(path="/utilisateurs")
	public Utilisateur add(@RequestBody Utilisateur utilisateur) {
		return this.utilisateurService.add(utilisateur);
	}

	@PutMapping(path = "/utilisateurs")
	public Utilisateur edit(@Valid @RequestBody Utilisateur activite) {
		return this.utilisateurService.edit(activite);
	}
	
	@GetMapping(path = "/utilisateurs/{id}")
	public Optional<Utilisateur> getById(@PathVariable(value = "id") Integer id) {
		return this.utilisateurService.find(id);
	}
	
	@DeleteMapping(path = "/utilisateurs/{id}")
	public void delete(@PathVariable(value = "id") Integer id) {
		this.utilisateurService.delete(id);
	}
}
