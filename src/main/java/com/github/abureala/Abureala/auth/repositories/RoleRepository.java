package com.github.abureala.Abureala.auth.repositories;

import com.github.abureala.Abureala.auth.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);


}
