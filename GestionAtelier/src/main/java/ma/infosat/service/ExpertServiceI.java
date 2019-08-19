package ma.infosat.service;

import java.util.List;
import java.util.Optional;

import ma.infosat.model.Expert;

public interface ExpertServiceI {
	public Expert add(Expert expert);

	public Optional<Expert> find(Integer id);

	public Expert edit(Expert expert);

	public void delete(Integer id);

	public List<Expert> getAll();
}
