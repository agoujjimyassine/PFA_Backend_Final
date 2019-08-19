package ma.infosat.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.infosat.model.Client;
import ma.infosat.repository.ClientRepository;
import ma.infosat.service.ClientServiceI;

@Service
@Transactional
public class ClientServiceImpl implements ClientServiceI {

	private static final Logger LOGGER = LoggerFactory.getLogger(ClientServiceImpl.class);

	@Autowired
	private ClientRepository clientRepository;

	@Override
	public Client add(Client client) {
		if (client != null)
			return clientRepository.save(client);
		else
			return null;
	}

	@Override
	public Optional<Client> find(Integer id) {
		return clientRepository.findById(id);
	}

	@Override
	public Client edit(Client client) {
		if (client != null)
			return clientRepository.save(client);
		else
			return null;
	}

	@Override
	public void delete(Integer id) {
		if (clientRepository.findById(id) != null)
			clientRepository.deleteById(id);
	}

	@Override
	public List<Client> getAll() {
		try {
			List<Client> clients = clientRepository.findAll();
			if (clients.isEmpty())
				return clients;
			else
				return Collections.emptyList();
		} catch (Exception e) {
			LOGGER.error("Erreur {} ", e);
			return Collections.emptyList();
		}
	}

}
