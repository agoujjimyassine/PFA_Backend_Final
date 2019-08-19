package ma.infosat.service;

import java.util.List;
import java.util.Optional;

import ma.infosat.model.Phase;

public interface PhaseServiceI {
	public Phase add(Phase phase);

	public Optional<Phase> find(Integer id);

	public Phase edit(Phase phase);

	public void delete(Integer id);

	public List<Phase> getAll();
}
