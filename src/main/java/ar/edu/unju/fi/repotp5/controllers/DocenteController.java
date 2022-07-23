package ar.edu.unju.fi.repotp5.controllers;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.repotp5.entity.Docente;
import ar.edu.unju.fi.repotp5.services.IDocenteService;
// import ar.edu.unju.fi.repotp5.util.ListaDocente;

@Controller
@RequestMapping("/docente")
public class DocenteController {
    private String titulo;
    private String titulForm;
    private String opcion;

    private List<Docente> docentes;

    private static final Log LOGGER = LogFactory.getLog(DocenteController.class);
    
    @Autowired
    private Docente docente;

    @Autowired
    @Qualifier(value = "docenteServiceMysql")
    private IDocenteService docenteService;
    
    @GetMapping("/nuevo")
    public String getDocentePage(Model model){
        this.titulo="Alta Docente";
        this.titulForm = "Nuevo Docente";
        this.opcion = "nuevo";
        model.addAttribute("titulo", this.titulo);
        model.addAttribute("titulo_form", this.titulForm);
        model.addAttribute("opcion", this.opcion);
        model.addAttribute(this.docente);
        return "nuevo_docente";
    }

    @PostMapping("/guardar")
    public String guardarDocente(@ModelAttribute("docente")Docente docente){        
        // docentes = ListaDocente.docentes;

        // if (docentes.add(docente)) {
        //     LOGGER.info("Se agregó un objeto a la lista de docentes");
        // }
        this.docenteService.guardarDocente(docente);
        LOGGER.info("se agrego docente con legajo nro:"+docente.getLegajo()+" a la base de datos");
        return "redirect:/docente/listado-docente";
    }

    @GetMapping("/editar/{legajo}")
    public ModelAndView editarDocente(@PathVariable(value = "legajo")int legajo){
        ModelAndView modelAndView = new ModelAndView("nuevo_docente");
        this.titulo = "Editar Docente";
        this.titulForm = "Editar Datos Docente";
        this.opcion = "editar";
        Docente docenteEncontrado = docenteService.obtenerDocentePorLegajo(legajo);
        modelAndView.addObject("titulo", this.titulo);
        modelAndView.addObject("titulo_form", this.titulForm);
        modelAndView.addObject("opcion", this.opcion);
        modelAndView.addObject(docenteEncontrado);
        return modelAndView;
    }

    @GetMapping("/eliminar/{legajo}")
    public String eliminarDocente(@PathVariable(value = "legajo")int legajo){
        docenteService.eliminarDocente(legajo);
        return "redirect:/docente/listado-docente";
    }

    @GetMapping("/listado-docente")
    public ModelAndView getListaDocentePage(){
        ModelAndView modelAndView = new ModelAndView("lista_docente");
        modelAndView.addObject("titulo", "Listado Docente");
        // this.docentes = ListaDocente.docentes;
        this.docentes = this.docenteService.getDocentes();
        modelAndView.addObject("docentes",this.docentes);
        return modelAndView;


    }
}
