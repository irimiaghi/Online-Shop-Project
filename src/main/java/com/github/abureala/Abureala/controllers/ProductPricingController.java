package com.github.abureala.Abureala.controllers;

import com.github.abureala.Abureala.model.Product;
import com.github.abureala.Abureala.services.ProductPricingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

import static com.github.abureala.Abureala.controllers.ProductsController.getProductData;

@Controller
@RequestMapping(value = "/pricing")
public class ProductPricingController {
    @Autowired
    private ProductPricingService productPricingService;


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String showPagePrice(@PathVariable("id") Long id, Model model) {
        Optional<Product> productOptional = productPricingService.getProductById(id);
        if (productOptional.isPresent()) {

            getProductData(model, productOptional);
            return "pricing/pricing_page";
        } else {
            return null;
        }
    }
}
