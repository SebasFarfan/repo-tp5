package ar.edu.unju.fi.repotp5.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
    private String titulo;

    @GetMapping("/")
    public ModelAndView getIndexPage(){
        ModelAndView modelAndView = new ModelAndView("index");
        this.titulo = "Principal";
        modelAndView.addObject("titulo", this.titulo);
        return modelAndView;
    }
}
