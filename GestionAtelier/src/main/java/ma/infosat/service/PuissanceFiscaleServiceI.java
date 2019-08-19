package ma.infosat.service;

import java.util.List;
import java.util.Optional;

import ma.infosat.model.PuissanceFiscale;

public interface PuissanceFiscaleServiceI {
	public PuissanceFiscale add(PuissanceFiscale puissanceFiscale);

	public Optional<PuissanceFiscale> find(Integer id);

	public PuissanceFiscale edit(PuissanceFiscale puissanceFiscale);

	public void delete(Integer id);

	public List<PuissanceFiscale> getAll();
}
