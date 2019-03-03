package com.github.abureala.Abureala.repositories;

import com.github.abureala.Abureala.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    List<Client> findAllByFirstName(String firstName);
}
