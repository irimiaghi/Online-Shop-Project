package com.github.abureala.Abureala.controllers;

import com.github.abureala.Abureala.model.Product;
import com.github.abureala.Abureala.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductsController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/products")
    public String showProducts(Model model) {
        List<Product> list = productService.giveAllProducts();

        model.addAttribute("productsList", list);
        model.addAttribute("companyName", "Abureala");

        return "products/products_page";
    }

    static void getProductData(Model model, Optional<Product> productOptional) {
        model.addAttribute("productId", productOptional.get().getId());
        model.addAttribute("productName", productOptional.get().getName());
        model.addAttribute("productBuyPrice", productOptional.get().getPriceBuy());
        model.addAttribute("productRentPrice", productOptional.get().getPriceRent());
        model.addAttribute("companyName", "Abureala");
    }
}
