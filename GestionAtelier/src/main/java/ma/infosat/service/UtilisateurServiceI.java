package ma.infosat.service;

import java.util.List;
import java.util.Optional;

import ma.infosat.model.Utilisateur;

public interface UtilisateurServiceI {
	public Utilisateur add(Utilisateur utilisateur);

	public Optional<Utilisateur> find(Integer id);

	public Utilisateur edit(Utilisateur utilisateur);

	public void delete(Integer id);

	public List<Utilisateur> getAll();
}
