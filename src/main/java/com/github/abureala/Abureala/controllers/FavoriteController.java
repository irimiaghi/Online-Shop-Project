package com.github.abureala.Abureala.controllers;

import com.github.abureala.Abureala.controllers.dto.DeleteFavoriteFormDto;
import com.github.abureala.Abureala.controllers.dto.NewFavoriteFormDto;
import com.github.abureala.Abureala.model.Favorite;
import com.github.abureala.Abureala.services.FavoritesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

import static com.github.abureala.Abureala.controllers.dto.DeleteFavoriteFormDto.DELETE_FAVORITE_FORM;
import static com.github.abureala.Abureala.controllers.dto.NewFavoriteFormDto.NEW_FAVORITE_FORM;

@Controller
@RequestMapping("/favorites")
public class FavoriteController {

    @Autowired
    private FavoritesService favoritesService;

    @RequestMapping(method = RequestMethod.GET)
    public String showFavorites(Model model) {
        List<Favorite> list = favoritesService.getAllFavorites();
        model.addAttribute("favoritesList", list);
        model.addAttribute("companyName", "Abureală");
        model.addAttribute(NEW_FAVORITE_FORM, new NewFavoriteFormDto());
        model.addAttribute(DELETE_FAVORITE_FORM, new DeleteFavoriteFormDto());

        return "favorites/favorites_page";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String createFavorite(@ModelAttribute(NEW_FAVORITE_FORM) NewFavoriteFormDto form) {
        favoritesService.createFavorite(form.getTitle(), form.getGenre(), form.getYear(), form.getRanking());

        return "redirect:/favorites";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteFavorite(@ModelAttribute(DELETE_FAVORITE_FORM) DeleteFavoriteFormDto form) {
        favoritesService.deleteFavorite(form.getFavoriteId());

        return "redirect:/favorites";
    }
}
