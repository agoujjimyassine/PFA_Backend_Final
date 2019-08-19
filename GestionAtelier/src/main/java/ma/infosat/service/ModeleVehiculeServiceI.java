package ma.infosat.service;

import java.util.List;
import java.util.Optional;

import ma.infosat.model.ModeleVehicule;

public interface ModeleVehiculeServiceI {
	public ModeleVehicule add(ModeleVehicule modeleVehicule);

	public Optional<ModeleVehicule> find(Integer id);

	public ModeleVehicule edit(ModeleVehicule modeleVehicule);

	public void delete(Integer id);

	public List<ModeleVehicule> getAll();
}
