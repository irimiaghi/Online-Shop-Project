package com.github.abureala.Abureala.controllers;

import com.github.abureala.Abureala.auth.model.User;
import com.github.abureala.Abureala.auth.repositories.UserRepository;
import com.github.abureala.Abureala.auth.service.UserService;
import com.github.abureala.Abureala.controllers.dto.DeleteFavoriteFormDto;
import com.github.abureala.Abureala.controllers.dto.NewFavoriteFormDto;
import com.github.abureala.Abureala.model.Favorite;
import com.github.abureala.Abureala.services.FavoritesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import static com.github.abureala.Abureala.controllers.dto.DeleteFavoriteFormDto.DELETE_FAVORITE_FORM;
import static com.github.abureala.Abureala.controllers.dto.NewFavoriteFormDto.NEW_FAVORITE_FORM;

@Controller
@RequestMapping("/favorites")
public class FavoriteController {

    @Autowired
    private FavoritesService favoritesService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;

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
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) Objects.requireNonNull(authentication).getPrincipal();
        String username = user.getUsername();
        User userr = userService.findByUsername(username);
        favoritesService.createFavorite(form.getTitle(), form.getGenre(), form.getYear(), form.getRanking(), form.setUserId());

        return "redirect:/favorites";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteFavorite(@ModelAttribute(DELETE_FAVORITE_FORM) DeleteFavoriteFormDto form) {
        favoritesService.deleteFavorite(form.getFavoriteId());

        return "redirect:/favorites";
    }

    private void createStuff() {
        User user1 = new User();
        user1.setId(4L);
        List<Favorite> favL = new LinkedList<>();
        user1.setFavoriteList(favL);
        List<Favorite> favoriteList = user1.getFavoriteList();
        Favorite fav1 = new Favorite();
        fav1.setGenre("gen");
        fav1.setRanking(5);
        fav1.setTitle("title");
        fav1.setYear("year");
        fav1.setId(3L);
        fav1.setUser(user1);
        favoriteList.add(fav1);
        userRepository.save(user1);
    }
}
