package ma.infosat.service;

import java.util.List;
import java.util.Optional;

import ma.infosat.model.MarqueVehicule;

public interface MarqueVehiculeServiceI {
	public MarqueVehicule add(MarqueVehicule marqueVehicule);

	public Optional<MarqueVehicule> find(Integer id);

	public MarqueVehicule edit(MarqueVehicule marqueVehicule);

	public void delete(Integer id);

	public List<MarqueVehicule> getAll();
}
