package com.github.abureala.Abureala.controllers;

import com.github.abureala.Abureala.controllers.dto.DeleteProductDto;
import com.github.abureala.Abureala.controllers.dto.NewProductDto;
import com.github.abureala.Abureala.controllers.dto.ProductListFormDto;
import com.github.abureala.Abureala.model.Product;
import com.github.abureala.Abureala.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

import static com.github.abureala.Abureala.controllers.dto.DeleteProductDto.DELETE_PRODUCT_FORM;
import static com.github.abureala.Abureala.controllers.dto.NewProductDto.NEW_PRODUCT_FORM;

@Controller
@RequestMapping(value = "management")
public class ManagementController {
    @Autowired
    ProductService productService;

    @RequestMapping(method = RequestMethod.GET)
    public String showProducts(Model model) {
        List<Product> list = productService.giveAllProducts();

        model.addAttribute("productListForm", new ProductListFormDto(list));
        model.addAttribute(NEW_PRODUCT_FORM, new NewProductDto());
        model.addAttribute(DELETE_PRODUCT_FORM, new DeleteProductDto());
        model.addAttribute("companyName", "Abureala");

        return "account/management_page";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveProducts(@ModelAttribute ProductListFormDto productListFormDto, Model model) {
        productService.saveProducts(productListFormDto.getProductList());
        return "redirect:/management";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String createClient(@ModelAttribute(NEW_PRODUCT_FORM) NewProductDto form) {
        productService.createProduct(form.getName(), form.getPriceBuy(), form.getPriceRent());

        return "redirect:/management";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteProduct(@ModelAttribute(DELETE_PRODUCT_FORM) DeleteProductDto form) {
        productService.deleteProduct(form.getProductId());

        return "redirect:/management";
    }
}
