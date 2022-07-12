package ar.edu.unju.fi.repotp5.controllers;

import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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

import ar.edu.unju.fi.repotp5.models.Curso;
import ar.edu.unju.fi.repotp5.models.Docente;
import ar.edu.unju.fi.repotp5.util.ListaCursos;
import ar.edu.unju.fi.repotp5.util.ListaDocente;

@Controller
@RequestMapping("/curso")
public class CursoController {
    private String titulo;

    public static final Log LOGGER = LogFactory.getLog(CursoController.class);

    private List<Docente> listaDocente = ListaDocente.docentes;
    private List<Curso> listaCursos = ListaCursos.cursos;

    @Autowired
    private Curso curso;

    @GetMapping("/nuevo")
    public String getCursoPage(Model model){
        this.titulo = "Nuevo Curso";
        model.addAttribute("titulo", this.titulo);
        model.addAttribute(this.curso);
        model.addAttribute("docentes", this.listaDocente);
        return "nuevo_curso";
    }

    @PostMapping("/guardar")
    public String guardarCurso(@Validated @ModelAttribute("curso")Curso curso, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {            
            LOGGER.info("objeto curso:"+curso.getTitulo());
            model.addAttribute("titulo", "Nuevo Curso");
            model.addAttribute(curso);
            model.addAttribute("docentes",this.listaDocente);
            return "nuevo_curso";
        }
        // buscar al docente seleccionado
        Optional<Docente> docente = this.listaDocente.stream().filter(d->d.getLegajo() == curso.getDocente().getLegajo()).findFirst();
        curso.setDocente(docente.get());

        if (listaCursos.add(curso)) {
            LOGGER.info("Se guardó el curso en la lista");            
        }
        return "redirect:/curso/listado-cursos";        
    }

    @GetMapping("/listado-cursos")
    public ModelAndView getListadoCursosPage(){
        ModelAndView modelAndView = new ModelAndView("lista_cursos");
        this.titulo = "Listado Cursos";
        modelAndView.addObject("titulo", this.titulo);
        modelAndView.addObject("cursos", this.listaCursos);
        return modelAndView;
    }


    
}
