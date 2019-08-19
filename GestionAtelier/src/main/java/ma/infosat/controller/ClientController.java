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

import ma.infosat.model.Client;
import ma.infosat.repository.ClientRepository;
import ma.infosat.service.ClientServiceI;

@CrossOrigin("*")
@RestController
public class ClientController {
	
	@Autowired
	private ClientServiceI clientService;
	
	@Autowired
	private ClientRepository clientRepository;
	
	public ClientController() {
	}
	
	@GetMapping(path="/clients")
	public Page<Client> getAll(){
		return this.clientRepository.findAll(new PageRequest(0, 5));
	}
	
	@PostMapping(path="/clients")
	public Client add(@RequestBody Client client){
		return this.clientService.add(client);
	}
	
	@PutMapping(path = "/clients")
	public Client edit(@Valid @RequestBody Client client) {
		return this.clientService.edit(client);
	}
	
	@GetMapping(path = "/clients/{id}")
	public Optional<Client> getById(@PathVariable(value = "id") Integer id) {
		return this.clientService.find(id);
	}
		
	@DeleteMapping(path = "/clients/{id}")
	public void delete(@PathVariable(value = "id") Integer id) {
		this.clientService.delete(id);
	}
}
