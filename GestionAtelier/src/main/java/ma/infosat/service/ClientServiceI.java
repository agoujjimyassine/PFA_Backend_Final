package ma.infosat.service;

import java.util.List;
import java.util.Optional;

import ma.infosat.model.Client;

public interface ClientServiceI {
	public Client add(Client client);

	public Optional<Client> find(Integer id);

	public Client edit(Client client);

	public void delete(Integer id);

	public List<Client> getAll();
}
