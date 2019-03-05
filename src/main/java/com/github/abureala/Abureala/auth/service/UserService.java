package com.github.abureala.Abureala.auth.service;

import com.github.abureala.Abureala.auth.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
