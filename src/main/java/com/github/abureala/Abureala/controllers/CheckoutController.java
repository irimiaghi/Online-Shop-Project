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
@RequestMapping("/checkout")
public class CheckoutController {

    @Autowired
    ProductPricingService productPricingService;

    @RequestMapping(value = "/buy/{id}", method = RequestMethod.GET)
    public String showPageBuy(@PathVariable("id") Long id, Model model) {
        Optional<Product> productOptional = productPricingService.getProductById(id);
        if (productOptional.isPresent()) {

            getProductData(model, productOptional);
            return "checkout/checkout_page_buy";
        } else {
            return null;
        }
    }

    @RequestMapping(value = "/rent/{id}", method = RequestMethod.GET)
    public String showPageRent(@PathVariable("id") Long id, Model model) {
        Optional<Product> productOptional = productPricingService.getProductById(id);
        if (productOptional.isPresent()) {

            getProductData(model, productOptional);
            return "checkout/checkout_page_rent";
        } else {
            return null;
        }
    }

    @RequestMapping(value = "/succes", method = RequestMethod.GET)
    public String showPageSucces() {
        return "checkout/checkout_succes_page";
    }
}
