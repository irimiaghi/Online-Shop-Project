package com.github.abureala.Abureala.controllers.dto;

import com.github.abureala.Abureala.auth.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class NewFavoriteFormDto {
    @Autowired
    UserRepository userRepository;

    public static final String NEW_FAVORITE_FORM = "newFavoriteForm";

    private String Title;
    private String Genre;
    private String Year;
    private int ranking;


    private Long userId;

    public NewFavoriteFormDto setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public String getTitle() {
        return Title;
    }

    public NewFavoriteFormDto setTitle(String title) {
        Title = title;
        return this;
    }

    public String getGenre() {
        return Genre;
    }

    public NewFavoriteFormDto setGenre(String genre) {
        Genre = genre;
        return this;
    }

    public String getYear() {
        return Year;
    }

    public NewFavoriteFormDto setYear(String year) {
        Year = year;
        return this;
    }

    public int getRanking() {
        return ranking;
    }

    public NewFavoriteFormDto setRanking(int ranking) {
        this.ranking = ranking;
        return this;
    }
}
