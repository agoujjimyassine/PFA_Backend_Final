package ma.infosat.service;

import java.util.List;
import java.util.Optional;

import ma.infosat.model.Commande;

public interface CommandeServiceI {

	public Commande add(Commande commande);

	public Optional<Commande> find(Integer id);

	public Commande edit(Commande commande);

	public void delete(Integer id);

	public List<Commande> getAll();
	
	public List<Commande> getByIdFournisseur(Integer id);
	
}
