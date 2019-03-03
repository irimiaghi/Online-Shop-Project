package com.github.abureala.Abureala.controllers;

import com.github.abureala.Abureala.services.ProductService;
import com.github.abureala.Abureala.model.Product;
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
        model.addAttribute("companyName", "Our company");

        return "products/products_page";
    }
}
