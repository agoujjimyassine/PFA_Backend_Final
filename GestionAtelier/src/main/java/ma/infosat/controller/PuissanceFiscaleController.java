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

import ma.infosat.model.PuissanceFiscale;
import ma.infosat.repository.PuissanceFiscaleRepository;
import ma.infosat.service.PuissanceFiscaleServiceI;

@CrossOrigin("*")
@RestController
public class PuissanceFiscaleController {
	
	@Autowired
	private PuissanceFiscaleServiceI puissanceFiscaleService;
	
	@Autowired
	private PuissanceFiscaleRepository puissanceFiscaleRepository;
	
	public PuissanceFiscaleController() {
	}
	
	@GetMapping(path="/puissanceFiscales")
	public Page<PuissanceFiscale> getAll(){
		return this.puissanceFiscaleRepository.findAll(new PageRequest(0, 5));
		
	}
	
	@PostMapping(path="/puissanceFiscales")
	public PuissanceFiscale add(@RequestBody PuissanceFiscale puissanceFiscale) {
		return this.puissanceFiscaleService.add(puissanceFiscale);
	}

	@PutMapping(path = "/puissanceFiscales")
	public PuissanceFiscale edit(@Valid @RequestBody PuissanceFiscale activite) {
		return this.puissanceFiscaleService.edit(activite);
	}
	
	@GetMapping(path = "/puissanceFiscales/{id}")
	public Optional<PuissanceFiscale> getById(@PathVariable(value = "id") Integer id) {
		return this.puissanceFiscaleService.find(id);
	}
	
	@DeleteMapping(path = "/puissanceFiscales/{id}")
	public void delete(@PathVariable(value = "id") Integer id) {
		this.puissanceFiscaleService.delete(id);
	}
}
