package com.github.abureala.Abureala.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @RequestMapping(value = "/login")
    public String showLoginPage (Model model) {
        return "login/login_page";
    }
}
