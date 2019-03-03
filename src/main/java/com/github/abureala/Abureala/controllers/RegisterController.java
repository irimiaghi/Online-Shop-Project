package com.github.abureala.Abureala.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegisterController {
    @RequestMapping(value = "/register")
    public String showRegisterPage (Model model) {
        return "login/register_page";
    }
}
