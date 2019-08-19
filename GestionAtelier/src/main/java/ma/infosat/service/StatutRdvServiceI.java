package ma.infosat.service;

import java.util.List;
import java.util.Optional;

import ma.infosat.model.StatutRdv;

public interface StatutRdvServiceI {
	public StatutRdv add(StatutRdv statutRdv);

	public Optional<StatutRdv> find(Integer id);

	public StatutRdv edit(StatutRdv statutRdv);

	public void delete(Integer id);

	public List<StatutRdv> getAll();

}
