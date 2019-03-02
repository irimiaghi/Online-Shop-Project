package com.github.abureala.Abureala.config.controllers;

import com.github.abureala.Abureala.config.model.Product;
import com.github.abureala.Abureala.config.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ProductsController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/products")
    public String showProducts(Model model) {
        List<Product> list = productService.giveAllProducts();

        model.addAttribute("productsList", list);
        model.addAttribute("companyName", "My company");

        return "products";
    }
}
