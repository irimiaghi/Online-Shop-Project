package com.github.abureala.Abureala.services;

import com.github.abureala.Abureala.auth.model.User;
import com.github.abureala.Abureala.model.Favorite;
import com.github.abureala.Abureala.repositories.FavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoritesServiceImpl implements FavoritesService {

    @Autowired
    private FavoriteRepository favoriteRepository;

    public List<Favorite> getAllFavorites() {
        return favoriteRepository.findAll();
    }

    @Override
    public Favorite createFavorite(String title, String genre, String year, int ranking, User user) {
        Favorite favorite = new Favorite();

        favorite.setTitle(title);
        favorite.setGenre(genre);
        favorite.setYear(year);
        favorite.setRanking(ranking);
        favorite.setUser(user);

        return favoriteRepository.save(favorite);
    }


    @Override
    public void deleteFavorite(Long id) {
        favoriteRepository.deleteById(id);
    }

    @Override
    public List<Favorite> getAllByUser(User user) {
        return favoriteRepository.getAllByUser(user);
    }
}
