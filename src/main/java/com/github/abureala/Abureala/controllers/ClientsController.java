package com.github.abureala.Abureala.controllers;

import com.github.abureala.Abureala.controllers.dto.DeleteClientFormDto;
import com.github.abureala.Abureala.controllers.dto.NewClientFormDto;
import com.github.abureala.Abureala.model.Client;
import com.github.abureala.Abureala.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

import static com.github.abureala.Abureala.controllers.dto.DeleteClientFormDto.DELETE_CLIENT_FORM;
import static com.github.abureala.Abureala.controllers.dto.NewClientFormDto.NEW_CLIENT_FORM;

@Controller
@RequestMapping("/clients")
public class ClientsController {

    @Autowired
    private ClientService clientService;

    @RequestMapping(method = RequestMethod.GET)
    public String showClients(Model model) {
        List<Client> list = clientService.getAllClients();

        model.addAttribute("clientsList", list);
        model.addAttribute("companyName", "My company");
        model.addAttribute(NEW_CLIENT_FORM, new NewClientFormDto());
        model.addAttribute(DELETE_CLIENT_FORM, new DeleteClientFormDto());

        return "clients/clients_page";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String createClient(@ModelAttribute(NEW_CLIENT_FORM) NewClientFormDto form) {
        clientService.createClient(form.getFirstName(), form.getLastName(), form.getEmail(), form.getPassword(), form.getAdmin());

        return "redirect:/clients";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteClient(@ModelAttribute(DELETE_CLIENT_FORM) DeleteClientFormDto form) {
        clientService.deleteClient(form.getClientId());

        return "redirect:/clients";
    }
}
