package ma.infosat.service;

import java.util.List;
import java.util.Optional;

import ma.infosat.model.Motif;

public interface MotifServiceI {
	public Motif add(Motif motif);

	public Optional<Motif> find(Integer id);

	public Motif edit(Motif motif);

	public void delete(Integer id);

	public List<Motif> getAll();
}
