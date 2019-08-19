package ma.infosat.service;

import java.util.List;
import java.util.Optional;

import ma.infosat.model.Fournisseur;

public interface FournisseurServiceI {
	public Fournisseur add(Fournisseur fournisseur);

	public Optional<Fournisseur> find(Integer id);

	public Fournisseur edit(Fournisseur fournisseur);

	public void delete(Integer id);

	public List<Fournisseur> getAll();
}
