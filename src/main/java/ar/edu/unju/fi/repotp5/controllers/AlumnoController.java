package ar.edu.unju.fi.repotp5.controllers;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.repotp5.entity.Alumno;
import ar.edu.unju.fi.repotp5.services.IAlumnoService;
import ar.edu.unju.fi.repotp5.util.ListaAlumnos;

@Controller
@RequestMapping("/alumno")
public class AlumnoController {

    private String titulo;
    private String tituloFormulario;

    @Autowired
    private Alumno alumno;

    @Autowired
    @Qualifier("AlumnoServiceImp")
    private IAlumnoService alumnoService;

    @Autowired
    @Qualifier("alumnoServiceMysql")
    private IAlumnoService alumnoService2;
    
    private List<Alumno> alumnos;

    private static final Log LOGGER = LogFactory.getLog(AlumnoController.class);

    @GetMapping("/nuevo")
    public String getAlumnoPage(Model model){
        this.titulo = "Alta Alumno";
        this.tituloFormulario = "Registro Nuevo Alumno";
        model.addAttribute("titulo", this.titulo);
        model.addAttribute("titulo_formulario", this.tituloFormulario);
        model.addAttribute(this.alumno);
        return "nuevo_alumno";
    }

    @PostMapping("/guardar")
    public String guardarAlumno(@Validated @ModelAttribute("alumno")Alumno alumno, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            this.titulo = "Alta Alumno";
            model.addAttribute("titulo", this.titulo);
            model.addAttribute("titulo_formulario", this.tituloFormulario);
            model.addAttribute(alumno);
            return "nuevo_alumno";            
        }
        
        // this.alumnos = ListaAlumnos.alumnos;
        // this.alumnos.add(alumno);        
        this.alumnoService2.guardarAlumno(alumno);
        return "redirect:/alumno/listado-alumnos";
    }
    
    @GetMapping("/listado-alumnos")
    public ModelAndView getlistaAlumnosPage(){
        ModelAndView modelAndView = new ModelAndView("lista_alumnos");
        this.titulo = "Lista Alumnos";
        // this.alumnos = ListaAlumnos.alumnos;
        this.alumnos = alumnoService2.getAlumnos();
        modelAndView.addObject("titulo", this.titulo);
        modelAndView.addObject("alumnos", this.alumnos);
        return modelAndView;

    }

    @GetMapping("/editar/{dni}")
    public ModelAndView getEditarAlumnoPage(@PathVariable(value = "dni")int dni){
        ModelAndView modelAndView = new ModelAndView("editar_alumno");
        this.titulo = "Editar Alumno";
        this.tituloFormulario = "Datos del Alumno";
        // Alumno alumnoEncontrado = alumnoService.buscarAlumno(dni);
        Alumno alumnoEncontrado = this.alumnoService2.buscarAlumno(dni);
        if (alumnoEncontrado == null) {
            LOGGER.warn("No existe el alumno con el dni:"+dni);
        }
        modelAndView.addObject("titulo", this.titulo);
        modelAndView.addObject("titulo_formulario", this.tituloFormulario);
        modelAndView.addObject("alumno", alumnoEncontrado);
        return modelAndView;
    }

    @PostMapping("/actualizar")
    public String actualizarAumno(@Validated @ModelAttribute("alumno")Alumno alumno, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            this.titulo = "Editar Alumno";
            model.addAttribute("titulo", this.titulo);
            model.addAttribute("titulo_formulario", this.tituloFormulario);
            model.addAttribute(alumno);
            return "editar_alumno";            
        }
        // this.alumnoService.modificarAlumno(alumno);
        this.alumnoService2.modificarAlumno(alumno);
        return "redirect:/alumno/listado-alumnos";

    }

    @GetMapping("/eliminar/{dni}")
    public String eliminarAlumno(@PathVariable(value = "dni")int dni, Model model){
        // if (this.alumnoService.eliminarAlumno(dni)) {
        if (this.alumnoService2.eliminarAlumno(dni)) {
            return "redirect:/alumno/listado-alumnos";
        } else {
            LOGGER.warn("No se puede elimnar al alumno con dni:"+dni);
            return "redirect:/alumno/listado-alumnos";
        }
    }
}
