package ma.infosat.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.infosat.model.Commande;
import ma.infosat.model.Dossier;
import ma.infosat.model.PieceDetachee;
import ma.infosat.repository.PieceDetacheeRepository;
import ma.infosat.service.CommandeServiceI;
import ma.infosat.service.DossierServiceI;
import ma.infosat.service.PieceDetacheeServiceI;

@Service
@Transactional
public class PieceDetacheeServiceImpl implements PieceDetacheeServiceI {

	private static final Logger LOGGER = LoggerFactory.getLogger(PieceDetacheeServiceImpl.class);

	@Autowired
	private PieceDetacheeRepository pieceDetacheeRepository;
	
	@Autowired
	private DossierServiceI dossierService;
	
	@Autowired
	private CommandeServiceI commandeService;

	@Override
	public PieceDetachee add(PieceDetachee pieceDetachee) {
		if (pieceDetachee != null)
			return pieceDetacheeRepository.save(pieceDetachee);
		else
			return null;
	}

	@Override
	public Optional<PieceDetachee> find(Integer id) {
		return pieceDetacheeRepository.findById(id);
	}

	@Override
	public PieceDetachee edit(PieceDetachee pieceDetachee) {
		if (pieceDetachee != null)
			return pieceDetacheeRepository.save(pieceDetachee);
		else
			return null;
	}

	@Override
	public void delete(Integer id) {
		if (pieceDetacheeRepository.findById(id) != null)
			pieceDetacheeRepository.deleteById(id);
	}

	@Override
	public List<PieceDetachee> getAll() {
		try {
			List<PieceDetachee> pieceDetachees = pieceDetacheeRepository.findAll();
			if (pieceDetachees.isEmpty())
				return pieceDetachees;
			else
				return Collections.emptyList();
		} catch (Exception e) {
			LOGGER.error("Erreur {} ", e);
			return Collections.emptyList();
		}
	}

	@Override
	public List<PieceDetachee> getByIdDossier(Integer id) {
		Optional<Dossier> dossier=dossierService.find(id);
		List<PieceDetachee> piecesDetachees=dossier.get().getPieceDetachees();
		return piecesDetachees;
	}

	@Override
	public List<PieceDetachee> getByIdCommande(Integer id) {
		Optional<Commande> commande=commandeService.find(id);
		List<PieceDetachee> piecesDetachees=commande.get().getPieceDetachees();
		return piecesDetachees;
	}

}
