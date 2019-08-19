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

import ma.infosat.model.TypeClient;
import ma.infosat.repository.TypeClientRepository;
import ma.infosat.service.TypeClientServiceI;

@CrossOrigin("*")
@RestController
public class TypeClientController {
	
	@Autowired
	private TypeClientServiceI typeClientService;
	
	@Autowired
	private TypeClientRepository typeClientRepository;

	public TypeClientController() {
	}
	
	@GetMapping(path="/typeClients")
	public Page<TypeClient> getAll(){
		return this.typeClientRepository.findAll(new PageRequest(0, 5));
		
	}
	
	@PostMapping(path="/typeClients")
	public TypeClient add(@RequestBody TypeClient typeClient) {
		return this.typeClientService.add(typeClient);
	}

	@PutMapping(path = "/typeClients")
	public TypeClient edit(@Valid @RequestBody TypeClient activite) {
		return this.typeClientService.edit(activite);
	}
	
	@GetMapping(path = "/typeClients/{id}")
	public Optional<TypeClient> getById(@PathVariable(value = "id") Integer id) {
		return this.typeClientService.find(id);
	}
		
	@DeleteMapping(path = "/typeClients/{id}")
	public void delete(@PathVariable(value = "id") Integer id) {
		this.typeClientService.delete(id);
	}
}
