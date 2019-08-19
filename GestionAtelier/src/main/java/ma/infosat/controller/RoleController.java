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

import ma.infosat.model.Role;
import ma.infosat.repository.RoleRepository;
import ma.infosat.service.RoleServiceI;

@CrossOrigin("*")
@RestController
public class RoleController {

	@Autowired
	private RoleServiceI roleService;
	
	@Autowired
	private RoleRepository roleRepository;
	
	public RoleController() {
	}
	
	@GetMapping(path="/roles")
	public Page<Role> getAll(){
		return this.roleRepository.findAll(new PageRequest(0, 5));
	}
	
	@PostMapping(path="/roles")
	public Role add(@RequestBody Role client){
		return this.roleService.add(client);
	}
	
	@PutMapping(path = "/roles")
	public Role edit(@Valid @RequestBody Role client) {
		return this.roleService.edit(client);
	}
	
	@GetMapping(path = "/roles/{id}")
	public Optional<Role> getById(@PathVariable(value = "id") Integer id) {
		return this.roleService.find(id);
	}
		
	@DeleteMapping(path = "/roles/{id}")
	public void delete(@PathVariable(value = "id") Integer id) {
		this.roleService.delete(id);
	}

	
}
