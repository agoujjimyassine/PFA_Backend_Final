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

import ma.infosat.model.RendezVous;
import ma.infosat.repository.RendezVousRepository;
import ma.infosat.service.RendezVousServiceI;

@CrossOrigin("*")
@RestController
public class RendezVousController {
	
	@Autowired
	private  RendezVousServiceI  rendezVousService;
	
	@Autowired
	private RendezVousRepository rendezVousRepository;

	public RendezVousController() {
	}

	@GetMapping(path="/rendezVouss")
	public Page<RendezVous> getAll(){
		return this.rendezVousRepository.findAll(new PageRequest(0, 5));
	}
	
	@GetMapping(path="/rendezVoussByIdDossier/{id}")
	public List<RendezVous> getByIdDossier(@PathVariable(value = "id") Integer id){
		return this.rendezVousService.getByIdDossier(id);
	}
	
	@PostMapping(path="/rendezVouss")
	public RendezVous add(@RequestBody RendezVous rendezVous) {
		return this.rendezVousService.add(rendezVous);
	}

	@PutMapping(path = "/rendezVouss")
	public RendezVous edit(@Valid @RequestBody RendezVous activite) {
		return this.rendezVousService.edit(activite);
	}
	
	@GetMapping(path = "/rendezVouss/{id}")
	public Optional<RendezVous> getById(@PathVariable(value = "id") Integer id) {
		return this.rendezVousService.find(id);
	}
	
	@DeleteMapping(path = "/rendezVouss/{id}")
	public void delete(@PathVariable(value = "id") Integer id) {
		this.rendezVousService.delete(id);
	}
}
