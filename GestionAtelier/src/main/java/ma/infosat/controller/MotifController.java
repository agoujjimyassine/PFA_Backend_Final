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

import ma.infosat.model.Motif;
import ma.infosat.repository.MotifRepository;
import ma.infosat.service.MotifServiceI;

@CrossOrigin("*")
@RestController
public class MotifController {
  
	@Autowired
	private MotifServiceI motifService;
	
	@Autowired
	private MotifRepository motifRepository;
	
	public MotifController() {
	}

	@GetMapping(path="/motifs")
	public Page<Motif> getAll(){
		return this.motifRepository.findAll(new PageRequest(0, 5));
		
	}
	
	@PostMapping(path="/motifs")
	public Motif add(@RequestBody Motif motif) {
		return this.motifService.add(motif);
	}

	@PutMapping(path = "/motifs")
	public Motif edit(@Valid @RequestBody Motif activite) {
		return this.motifService.edit(activite);
	}
	
	@GetMapping(path = "/motifs/{id}")
	public Optional<Motif> getById(@PathVariable(value = "id") Integer id) {
		return this.motifService.find(id);
	}
	
	@DeleteMapping(path = "/motifs/{id}")
	public void delete(@PathVariable(value = "id") Integer id) {
		this.motifService.delete(id);
	}
}
