package com.github.abureala.Abureala.auth.service;

import com.github.abureala.Abureala.auth.model.Role;
import com.github.abureala.Abureala.auth.model.User;
import com.github.abureala.Abureala.auth.repositories.RoleRepository;
import com.github.abureala.Abureala.auth.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Optional<Role> role = roleRepository.findById(1L);
        Set<Role> myRole = new HashSet<>();
        myRole.add(role.get());
        user.setRoles(myRole);
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
