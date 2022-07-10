package ar.edu.unju.fi.repotp5.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.repotp5.models.Alumno;
import ar.edu.unju.fi.repotp5.util.ListaAlumnos;

@Controller
@RequestMapping("/alumno")
public class AlumnoController {

    private String titulo;

    @Autowired
    private Alumno alumno;
    
    private List<Alumno> alumnos;

    @GetMapping("/nuevo")
    public String getAlumnoPage(Model model){
        this.titulo = "Alta Alumno";
        model.addAttribute("titulo", this.titulo);
        model.addAttribute(this.alumno);
        return "nuevo_alumno";
    }

    @PostMapping("/guardar")
    public String guardarAlumno(@Validated @ModelAttribute("alumno")Alumno alumno, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            this.titulo = "Alta Alumno";
            model.addAttribute("titulo", this.titulo);
            model.addAttribute(alumno);
            return "nuevo_alumno";            
        }
        
        this.alumnos = ListaAlumnos.alumnos;
        this.alumnos.add(alumno);        
        return "redirect:/alumno/listado-alumnos";
    }
    
    @GetMapping("/listado-alumnos")
    public ModelAndView getlistaAlumnosPage(){
        ModelAndView modelAndView = new ModelAndView("lista_alumnos");
        this.titulo = "Lista Alumnos";
        this.alumnos = ListaAlumnos.alumnos;
        modelAndView.addObject("titulo", this.titulo);
        modelAndView.addObject("alumnos", this.alumnos);
        return modelAndView;

    }
}
