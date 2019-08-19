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

import ma.infosat.model.EtatPiece;
import ma.infosat.repository.EtatPieceRepository;
import ma.infosat.service.EtatPieceServiceI;

@CrossOrigin("*")
@RestController
public class EtatPieceController {

	@Autowired
	private EtatPieceServiceI etatPieceService;
	
	@Autowired
	private EtatPieceRepository etatPieceRepository;
	
	public EtatPieceController() {
	}
	
	@GetMapping(path="/etatPieces")
	public Page<EtatPiece> getAll(){
		return this.etatPieceRepository.findAll(new PageRequest(0, 5));
	}
	
	@PostMapping(path="/etatPieces")
	public EtatPiece add(@RequestBody EtatPiece etatPiece){
		return this.etatPieceService.add(etatPiece);
	}
	
	@PutMapping(path = "/etatPieces")
	public EtatPiece edit(@Valid @RequestBody EtatPiece etatPiece) {
		return this.etatPieceService.edit(etatPiece);
	}
	
	@GetMapping(path = "/etatPieces/{id}")
	public Optional<EtatPiece> getById(@PathVariable(value = "id") Integer id) {
		return this.etatPieceService.find(id);
	}
		
	@DeleteMapping(path = "/etatPieces/{id}")
	public void delete(@PathVariable(value = "id") Integer id) {
		this.etatPieceService.delete(id);
	}
	
}
