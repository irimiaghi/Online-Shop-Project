package com.github.abureala.Abureala.auth.controllers;

import com.github.abureala.Abureala.auth.model.User;
import com.github.abureala.Abureala.auth.service.SecurityService;
import com.github.abureala.Abureala.auth.service.UserService;
import com.github.abureala.Abureala.auth.validator.UserValidator;
import com.github.abureala.Abureala.controllers.dto.NewClientFormDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import static com.github.abureala.Abureala.controllers.dto.NewClientFormDto.NEW_CLIENT_FORM;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        model.addAttribute(NEW_CLIENT_FORM, new NewClientFormDto());

        return "login/registration_page";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "login/registration_page";
        }

        userService.save(userForm);

        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/index";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login/login_page";
    }

    @GetMapping({"/", "/index", "/welcome"})
    public String welcome(Model model) {
        return "index";
    }
}