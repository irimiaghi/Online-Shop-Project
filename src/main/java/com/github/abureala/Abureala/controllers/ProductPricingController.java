package com.github.abureala.Abureala.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Controller
public class ProductPricingController {

    @RequestMapping(value = "/buy")
    public String showPagePrice(Model model) {

        return "Product_pricing";
    }

}
