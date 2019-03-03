package com.github.abureala.Abureala.services;

import com.github.abureala.Abureala.model.Client;
import com.github.abureala.Abureala.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client createClient(String firstName, String lastName) {
        Client client = new Client();

        client.setFirstName(firstName);
        client.setLastName(lastName);

        return clientRepository.save(client);
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}
