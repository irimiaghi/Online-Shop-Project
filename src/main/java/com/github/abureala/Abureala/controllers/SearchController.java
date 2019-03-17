package com.github.abureala.Abureala.controllers;

import com.github.abureala.Abureala.model.Product;
import com.github.abureala.Abureala.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SearchController {

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/search")
    public String Search(@RequestParam(value = "searchTerm", required = false) String searchTerm, Model model) {
        List<Product> list = productService.findAllByNameLike(searchTerm);
        model.addAttribute("searchTerm", searchTerm);
        model.addAttribute("searchResult", list);
        return "search/search";
    }


}
