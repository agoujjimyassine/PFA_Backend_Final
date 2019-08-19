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

import ma.infosat.model.Expert;
import ma.infosat.repository.ExpertRepository;
import ma.infosat.service.ExpertServiceI;

@CrossOrigin("*")
@RestController
public class ExpertController {
	
	@Autowired
	private ExpertServiceI expertService;
	
	@Autowired
	private ExpertRepository expertRepository;
	
	public ExpertController() {
	}
	
	@GetMapping(path="/experts")
	public Page<Expert> getAll(){
		return this.expertRepository.findAll(new PageRequest(0, 5));
	}
	
	@PostMapping(path="/experts")
	public Expert add(@RequestBody Expert expert){
		return this.expertService.add(expert);
	}
	
	@PutMapping(path = "/experts")
	public Expert edit(@Valid @RequestBody Expert expert) {
		return this.expertService.edit(expert);
	}
	
	@GetMapping(path = "/experts/{id}")
	public Optional<Expert> getById(@PathVariable(value = "id") Integer id) {
		return this.expertService.find(id);
	}
	
	@DeleteMapping(path = "/experts/{id}")
	public void delete(@PathVariable(value = "id") Integer id) {
		this.expertService.delete(id);
	}
}
