package ar.edu.unju.fi.repotp5.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactoController {
    private String titulo;

    @GetMapping("/contacto")
    public String getContactoPage(Model model){
        this.titulo = "Contacto";
        model.addAttribute("titulo", this.titulo);
        return "contacto";

    }
}
