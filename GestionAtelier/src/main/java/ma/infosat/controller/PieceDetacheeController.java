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

import ma.infosat.model.PieceDetachee;
import ma.infosat.repository.PieceDetacheeRepository;
import ma.infosat.service.PieceDetacheeServiceI;

@CrossOrigin("*")
@RestController
public class PieceDetacheeController {
	
	@Autowired
	private PieceDetacheeServiceI pieceDetacheeService;
	
	@Autowired
	private PieceDetacheeRepository pieceDetacheeRepository;
	
	public PieceDetacheeController() {
	}
	
	@GetMapping(path="/countPieceDetacheesByNom/{nom}")
	public Integer countPieceDetacheeByNom(@PathVariable(value = "nom") String nom){
		return pieceDetacheeRepository.countPieceDetacheeByNom(nom);
	}
		
	@GetMapping(path="/pieceDetachees")
	public Page<PieceDetachee> getAll(){
		return this.pieceDetacheeRepository.findAll(new PageRequest(0, 5));
	}
	
	@GetMapping(path="/pieceDetacheesByIdDossier/{id}")
	public List<PieceDetachee> getByIdDossier(@PathVariable(value = "id") Integer id){
		return this.pieceDetacheeService.getByIdDossier(id);
	}
	
	@GetMapping(path="/pieceDetacheesByIdCommande/{id}")
	public List<PieceDetachee> getByIdCommande(@PathVariable(value = "id") Integer id){
		return this.pieceDetacheeService.getByIdCommande(id);
	}
	
	@PostMapping(path="/pieceDetachees")
	public PieceDetachee add(@RequestBody PieceDetachee pieceDetachee){
		return this.pieceDetacheeService.add(pieceDetachee);
	}
	
	@PutMapping(path = "/pieceDetachees")
	public PieceDetachee edit(@Valid @RequestBody PieceDetachee pieceDetachee) {
		return this.pieceDetacheeService.edit(pieceDetachee);
	}
	
	@GetMapping(path = "/pieceDetachees/{id}")
	public Optional<PieceDetachee> getById(@PathVariable(value = "id") Integer id) {
		return this.pieceDetacheeService.find(id);
	}
	
	@DeleteMapping(path = "/pieceDetachees/{id}")
	public void delete(@PathVariable(value = "id") Integer id) {
		this.pieceDetacheeService.delete(id);
	}
}
