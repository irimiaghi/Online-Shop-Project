package com.github.abureala.Abureala.auth.repositories;

import com.github.abureala.Abureala.auth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

}
