package ar.edu.unju.fi.repotp5.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class agendaController {
    private String tituloPagina;

    @GetMapping("/agenda")
    public String getAgendaPage(Model model) {
        // ModelAndView modelAndView = new ModelAndView("agenda");
        // this.tituloPagina="<title>Agenda</title>";
        // modelAndView.addObject("titulo", this.tituloPagina);
        this.tituloPagina = "Agenda";
        model.addAttribute("titulo", this.tituloPagina);

        return "agenda";

    }
}
