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

import ar.edu.unju.fi.repotp5.entity.Beca;
import ar.edu.unju.fi.repotp5.entity.Curso;
import ar.edu.unju.fi.repotp5.services.IBecaService;
import ar.edu.unju.fi.repotp5.services.ICursoService;

@Controller
@RequestMapping(path = "/beca")
public class BecaController {
    public static final Log LOGGER = LogFactory.getLog(BecaController.class);

    private String titulo;
    private String tituloForm;
    private String opcion;
    private List<Curso> listaCursos;
    private List<Beca> listBecas;

    @Autowired
    @Qualifier(value = "becaServiceMysql")
    private IBecaService becaService; 

    @Autowired
    @Qualifier(value = "cursoServiceMysql")
    private ICursoService cursoService;

    @Autowired
    private Beca beca;

    @GetMapping("/nuevo")
    private String getBecaPage(Model model) {
        this.titulo = "Alta de beca";
        this.tituloForm = "Registro de Beca";
        this.opcion = "nuevo";
        this.listaCursos = this.cursoService.getCursos();
        model.addAttribute("titulo", this.titulo);
        model.addAttribute("titulo_formulario", this.tituloForm);
        model.addAttribute("opcion", this.opcion);
        model.addAttribute("cursos", this.listaCursos);
        model.addAttribute(this.beca);
        return "nuevo_beca";
    }

    @PostMapping("/guardar")
    private String guardarBeca(@Validated @ModelAttribute("beca")Beca beca, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            LOGGER.error("No se puede guardar la beca cuyo codigo:"+beca.getCodigo()+"estado:"+beca.getEstado());
            model.addAttribute("titulo", this.titulo);
            model.addAttribute("titulo_formulario", this.tituloForm);
            model.addAttribute("opcion", this.opcion);
            model.addAttribute("cursos", this.listaCursos);            
            model.addAttribute(beca);
            return "nuevo_beca";
        } else {
            Curso cursoSeleccionado = this.cursoService.getCurso(beca.getCurso().getCodigo());
            beca.setCurso(cursoSeleccionado);
            if (beca.getEstado()==null) {
                beca.setEstado("pendiente");
            }
            becaService.guardarBeca(beca);
            LOGGER.info("se guardó la beca con estado:"+beca.getEstado());
            return "redirect:/beca/listado-becas";
        }
    }

    @GetMapping("/editar/{codigo}")
    public ModelAndView editarBeca(@PathVariable(value = "codigo")Long codigo) {
        ModelAndView modelAndView = new ModelAndView("nuevo_beca");
        this.titulo = "Editar Beca";
        this.tituloForm = "Actualizar datos de Beca";
        this.opcion = "editar";
        this.listaCursos = cursoService.getCursos();
        Beca becaEncontrada = becaService.getBeca(codigo);
        modelAndView.addObject("titulo", this.titulo);
        modelAndView.addObject("titulo_formulario", this.tituloForm);
        modelAndView.addObject("opcion", this.opcion);
        modelAndView.addObject("cursos", this.listaCursos);
        modelAndView.addObject(becaEncontrada);
        return modelAndView;
    }

    @GetMapping("/eliminar/{codigo}")
    public String eliminarBeca(@PathVariable(value = "codigo")Long codigo) {
        this.becaService.eliminarBeca(codigo);
        return "redirect:/beca/listado-becas";
    }

    @GetMapping("/listado-becas")
    public ModelAndView getListadobecasPage() {
        ModelAndView modelAndView = new ModelAndView("lista_becas");
        this.titulo = "Listado Becas";
        this.listBecas = becaService.getbecas();
        modelAndView.addObject("titulo", this.titulo);
        modelAndView.addObject("becas", this.listBecas);
        return modelAndView;
    }


    
}
