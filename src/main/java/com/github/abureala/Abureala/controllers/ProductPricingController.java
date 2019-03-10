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

@Controller
@RequestMapping(value = "/pricing")
public class ProductPricingController {
    @Autowired
    private ProductPricingService productPricingService;


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String showPagePrice(@PathVariable("id") Long id, Model model) {
        Optional<Product> productOptional = productPricingService.getProductById(id);
        if (productOptional.isPresent()) {

            model.addAttribute("productId", productOptional.get().getId());
            model.addAttribute("productName", productOptional.get().getName());
            model.addAttribute("productBuyPrice", productOptional.get().getPriceBuy());
            return "pricing/pricing_page";
        } else {
            return null;
        }
    }
}
//    @RequestMapping(value = "/rent")
//    public String getName(String name) {
//        return productPricingRepository.findByName(name):
//
//    }
//    @RequestMapping(value = "/rent")
//    public String getBuy(String price) {
//        return productPricingRepository.findByPrice_buy(price);
//
//    }
//
//    @RequestMapping(value = "/buy")
//    public String getName(String name) {
//        return productPricingRepository.findByName(name);
//
//    }
//}
