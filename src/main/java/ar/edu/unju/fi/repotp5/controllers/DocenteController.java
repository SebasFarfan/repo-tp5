package ar.edu.unju.fi.repotp5.controllers;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.repotp5.entity.Docente;
import ar.edu.unju.fi.repotp5.util.ListaDocente;

@Controller
@RequestMapping("/docente")
public class DocenteController {
    private String titulo;

    private List<Docente> docentes;

    private static final Log LOGGER = LogFactory.getLog(DocenteController.class);
    
    @Autowired
    private Docente docente;
    
    @GetMapping("/nuevo")
    public String getDocentePage(Model model){
        this.titulo="Alta Docente";
        model.addAttribute("titulo", this.titulo);
        model.addAttribute(this.docente);
        return "nuevo_docente";
    }

    @PostMapping("/guardar")
    public String guardarDocente(@ModelAttribute("docente")Docente docente){        
        docentes = ListaDocente.docentes;
        if (docentes.add(docente)) {
            LOGGER.info("Se agregó un objeto a la lista de docentes");
        }
                
        return "redirect:/docente/listado-docente";
    }

    @GetMapping("/listado-docente")
    public ModelAndView getListaDocentePage(){
        ModelAndView modelAndView = new ModelAndView("lista_docente");
        modelAndView.addObject("titulo", "Listado Docente");
        this.docentes = ListaDocente.docentes;
        modelAndView.addObject("docentes",this.docentes);
        return modelAndView;


    }
}
