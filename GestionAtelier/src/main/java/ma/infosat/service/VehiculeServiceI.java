package ma.infosat.service;

import java.util.List;
import java.util.Optional;

import ma.infosat.model.Vehicule;

public interface VehiculeServiceI {
	public Vehicule add(Vehicule vehicule);

	public Optional<Vehicule> find(Integer id);

	public Vehicule edit(Vehicule vehicule);

	public void delete(Integer id);

	public List<Vehicule> getAll();
}
