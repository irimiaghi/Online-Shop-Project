package com.github.abureala.Abureala.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountController {
    public String showLoginPage(Model model) {
        return "account/account_page";
    }


}
