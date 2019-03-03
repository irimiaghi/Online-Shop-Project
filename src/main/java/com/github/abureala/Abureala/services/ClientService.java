package com.github.abureala.Abureala.services;

import com.github.abureala.Abureala.model.Client;

import java.util.List;

public interface ClientService {

    List<Client> getAllClients();

    Client createClient(String firstName, String lastName, String email, String password, Boolean admin);

    void deleteClient(Long id);
}
