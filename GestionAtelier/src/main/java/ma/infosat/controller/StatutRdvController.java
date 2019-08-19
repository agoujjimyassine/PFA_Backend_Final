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

import ma.infosat.model.StatutRdv;
import ma.infosat.repository.StatutRdvRepository;
import ma.infosat.service.StatutRdvServiceI;

@CrossOrigin("*")
@RestController
public class StatutRdvController {
	
	@Autowired
	private StatutRdvServiceI statutRdvService;
	
	@Autowired
	private StatutRdvRepository statutRdvRepository;
	
	public StatutRdvController() {
	}

	@GetMapping(path="/statutRdvs")
	public Page<StatutRdv> getAll(){
		return this.statutRdvRepository.findAll(new PageRequest(0, 5));
		
	}
	
	@PostMapping(path="/statutRdvs")
	public StatutRdv add(@RequestBody StatutRdv statutRdv) {
		return this.statutRdvService.add(statutRdv);
	}

	@PutMapping(path = "/statutRdvs")
	public StatutRdv edit(@Valid @RequestBody StatutRdv activite) {
		return this.statutRdvService.edit(activite);
	}
	
	@GetMapping(path = "/statutRdvs/{id}")
	public Optional<StatutRdv> getById(@PathVariable(value = "id") Integer id) {
		return this.statutRdvService.find(id);
	}
	
	@DeleteMapping(path = "/statutRdvs/{id}")
	public void delete(@PathVariable(value = "id") Integer id) {
		this.statutRdvService.delete(id);
	}
}
