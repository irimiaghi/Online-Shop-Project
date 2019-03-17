package com.github.abureala.Abureala.controllers;

import com.github.abureala.Abureala.model.Product;
import com.github.abureala.Abureala.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class SearchController {

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String Search(@RequestParam(value = "searchTerm", required = false) String searchTerm, Model model) {
        List<Optional<Product>> list = productService.findByname(searchTerm);
        model.addAttribute("searchTerm", searchTerm);
        model.addAttribute("searchResult", list);
        return "search/search";
    }


}
