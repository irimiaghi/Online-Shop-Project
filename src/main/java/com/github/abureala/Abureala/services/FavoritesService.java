package com.github.abureala.Abureala.services;

import com.github.abureala.Abureala.model.Favorite;

import java.util.List;

public interface FavoritesService {

    List<Favorite> getAllFavorites();

    public Favorite createFavorite(String title, String genre, String year, int ranking);

    void deleteFavorite(Long id);
}
