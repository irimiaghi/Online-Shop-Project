package com.github.abureala.Abureala.services;

import com.github.abureala.Abureala.auth.model.User;
import com.github.abureala.Abureala.model.Favorite;

import java.util.List;

public interface FavoritesService {

    List<Favorite> getAllFavorites();

    public Favorite createFavorite(String title, String genre, String year, int ranking, User user);

    void deleteFavorite(Long id);

    List<Favorite> getAllByUser(User user);
}
