package ma.infosat.service;

import java.util.List;
import java.util.Optional;

import ma.infosat.model.Historique;

public interface HistoriqueServiceI {
	public Historique add(Historique historique);

	public Optional<Historique> find(Integer id);

	public Historique edit(Historique historique);

	public void delete(Integer id);

	public List<Historique> getAll();
}
