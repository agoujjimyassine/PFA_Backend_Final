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
import ma.infosat.model.Fournisseur;
import ma.infosat.repository.CommandeRepository;
import ma.infosat.service.CommandeServiceI;
import ma.infosat.service.FournisseurServiceI;

@Service
@Transactional
public class CommandeServiceImpl implements CommandeServiceI{

	private static final Logger LOGGER = LoggerFactory.getLogger(ClientServiceImpl.class);

	@Autowired
	private CommandeRepository commandeRepository;

	@Autowired
	private FournisseurServiceI fournisseurService;
	
	@Override
	public Commande add(Commande commande) {
		if (commande != null)
			return commandeRepository.save(commande);
		else
			return null;
	}

	@Override
	public Optional<Commande> find(Integer id) {
		return commandeRepository.findById(id);
	}

	@Override
	public Commande edit(Commande commande) {
		if (commande != null)
			return commandeRepository.save(commande);
		else
			return null;
	}

	@Override
	public void delete(Integer id) {
		if (commandeRepository.findById(id) != null)
			commandeRepository.deleteById(id);
	}

	@Override
	public List<Commande> getAll() {
		try {
			List<Commande> commandes = commandeRepository.findAll();
			if (commandes.isEmpty())
				return commandes;
			else
				return Collections.emptyList();
		} catch (Exception e) {
			LOGGER.error("Erreur {} ", e);
			return Collections.emptyList();
		}
	}

	@Override
	public List<Commande> getByIdFournisseur(Integer id) {
		Optional<Fournisseur> fournisseur=fournisseurService.find(id);
		List<Commande> commandes=fournisseur.get().getCommandes();
		return commandes;
	}

}
