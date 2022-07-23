package ar.edu.unju.fi.repotp5.controllers;

import java.util.List;
// import java.util.Optional;

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

import ar.edu.unju.fi.repotp5.entity.Curso;
import ar.edu.unju.fi.repotp5.entity.Docente;
import ar.edu.unju.fi.repotp5.services.ICursoService;
import ar.edu.unju.fi.repotp5.services.IDocenteService;
// import ar.edu.unju.fi.repotp5.util.ListaCursos;
// import ar.edu.unju.fi.repotp5.util.ListaDocente;

@Controller
@RequestMapping("/curso")
public class CursoController {
    private String titulo;

    public static final Log LOGGER = LogFactory.getLog(CursoController.class);

    // private List<Docente> listaDocente = ListaDocente.docentes;
    // private List<Curso> listaCursos = ListaCursos.cursos;
    private List<Docente> listaDocente;
    private List<Curso> listaCursos;
    private String opcion;
    private String tituloForm;

    @Autowired
    private Curso curso;

    @Autowired
    @Qualifier(value = "cursoServiceMysql")
    private ICursoService cursoService;

    @Autowired
    @Qualifier(value = "docenteServiceMysql")
    private IDocenteService docenteService;


    @GetMapping("/nuevo")
    public String getCursoPage(Model model){
        this.titulo = "Nuevo Curso";
        this.opcion = "nuevo";
        model.addAttribute("titulo", this.titulo);
        model.addAttribute("opcion", this.opcion);
        model.addAttribute(this.curso);
        this.listaDocente = docenteService.getDocentes();
        model.addAttribute("docentes", this.listaDocente);
        return "nuevo_curso";
    }

    @PostMapping("/guardar")
    public String guardarCurso(@Validated @ModelAttribute("curso")Curso curso, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {            
            LOGGER.info("objeto curso:"+curso.getTitulo());
            model.addAttribute("titulo", "Nuevo Curso");
            model.addAttribute(curso);
            this.listaDocente = docenteService.getDocentes();
            model.addAttribute("docentes",this.listaDocente);
            return "nuevo_curso";
        }
        // buscar al docente seleccionado
        // Optional<Docente> docente = this.listaDocente.stream().filter(d->d.getLegajo() == curso.getDocente().getLegajo()).findFirst();
        // curso.setDocente(docente.get());
        Docente docenteSeleccionado = docenteService.obtenerDocentePorLegajo(curso.getDocente().getLegajo());
        curso.setDocente(docenteSeleccionado);

        // if (listaCursos.add(curso)) {
        //     LOGGER.info("Se guardó el curso en la lista");            
        // }
        cursoService.guardarCurso(curso);
        LOGGER.info("se guardó el curso:"+curso.getTitulo());
        return "redirect:/curso/listado-cursos";        
    }

    @GetMapping("/listado-cursos")
    public ModelAndView getListadoCursosPage(){
        ModelAndView modelAndView = new ModelAndView("lista_cursos");
        this.titulo = "Listado Cursos";
        modelAndView.addObject("titulo", this.titulo);
        this.listaCursos = cursoService.getCursos();
        modelAndView.addObject("cursos", this.listaCursos);
        return modelAndView;
    }

    @GetMapping("/editar/{codigo}")
    public ModelAndView editarCurso(@PathVariable(value = "codigo")int codigo) {
        ModelAndView modelAndView = new ModelAndView("nuevo_curso");
        this.titulo = "Editar Curso";
        this.tituloForm = "Editar Datos de Curso";
        this.opcion = "editar";
        this.listaDocente = docenteService.getDocentes();
        Curso cursoEncontrado = cursoService.getCurso(codigo);
        modelAndView.addObject("titulo", this.titulo);
        modelAndView.addObject("titulo_form", this.tituloForm);
        modelAndView.addObject("opcion", this.opcion);
        modelAndView.addObject("docentes", this.listaDocente);
        modelAndView.addObject(cursoEncontrado);
        return modelAndView;

    }

    @GetMapping("/eliminar/{codigo}")
    public String eliminarCurso(@PathVariable(value = "codigo")int codigo) {
        this.cursoService.eliminarCurso(codigo);
        return "redirect:/curso/listado-cursos";
    }


    
}
