package com.REG.MTNSIMCARD.Controller;

import com.REG.MTNSIMCARD.Models.Client;
import com.REG.MTNSIMCARD.imp.ClientServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ClientController {

    ClientServiceImplementation service;

    @Autowired
    public ClientController(ClientServiceImplementation service) {
        this.service = service;
    }

    @GetMapping("/")
    public String showHomePage() {

        return "HOMEE";
    }

    @GetMapping("/delete/{id}")
    public String adminView(@PathVariable("id") long id) {
        service.deleteClient(id);
        return "redirect:/clients";
    }

    //public ClientController(ClientService clientService) {
    // this.clientService = clientService;
    //}
    @GetMapping("/clients")
    public String listClients(Model model) {
        List<Client> clients = service.findAllClients();
        model.addAttribute("clients", clients);
        return "clients-list";
    }

    @GetMapping("/clients/nem")
    public String creatClientForm(Model model) {
        Client client = new Client();
        model.addAttribute("client", client);
        return "clients-create";

    }
//    @PostMapping("/client/new")
//    public String saveClient(@ModelAttribute("client")Client client){
//        clientService.saveclient(client);
//        return "redirect:/clients";
//    }

//    @GetMapping("/user/signup")
//    public String getSignupForm(Model mode){
//
//
//        return "signup-page";
//    }

    @GetMapping("/client/new")
    public String getClientRegisterForm(Model model) {
        Client client = new Client();
        model.addAttribute("client", client);
        model.addAttribute("pageTitle", "Register Here");
        return "clientRegisterForm";
    }

    @PostMapping("/client/save")
    public String registerClient(Client client, Model model, RedirectAttributes ra) {
        try {
            Client savedClient = service.saveclient(client);
            model.addAttribute("client", savedClient);
            ra.addFlashAttribute("message", "Client registered successfully");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        client.setFirstname("");
        client.setLastname("");
        client.setEmail("");
        client.setId_no(0);
        return "redirect:/client/new";
    }

    @GetMapping("/edit/{id}")
    public String edituser(@PathVariable("id") long id, Model model) {
        Client client = service.findClientById(id);
        model.addAttribute("client", client);
        return "EditClient";
    }
    @PostMapping("/edit/{id}")
    public String UpdateUser(@PathVariable("id") long id,@ModelAttribute("client") Client client){
        client.setId(id);
        service.updateClient(client);
        return "redirect:/clients";
    }
}
