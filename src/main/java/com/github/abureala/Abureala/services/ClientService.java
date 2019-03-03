package com.github.abureala.Abureala.services;

import com.github.abureala.Abureala.model.Client;

import java.util.List;

public interface ClientService {

    List<Client> getAllClients();

    Client createClient(String firstName, String lastName);

    void deleteClient(Long id);
}
