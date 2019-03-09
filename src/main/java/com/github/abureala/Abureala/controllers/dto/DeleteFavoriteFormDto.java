package com.github.abureala.Abureala.controllers.dto;

public class DeleteFavoriteFormDto {

    public static final String DELETE_FAVORITE_FORM = "deleteFavoriteForm";

    private Long favoriteId;

    public Long getFavoriteId() {
        return favoriteId;
    }

    public void setFavoriteId(Long favoriteId) {
        this.favoriteId = favoriteId;
    }
}
