package com.github.abureala.Abureala.repositories;

import com.github.abureala.Abureala.auth.model.User;
import com.github.abureala.Abureala.model.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
    public List<Favorite> getAllByUser(User user);
}
