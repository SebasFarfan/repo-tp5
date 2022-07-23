package ar.edu.unju.fi.repotp5.services.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unju.fi.repotp5.entity.Curso;
import ar.edu.unju.fi.repotp5.repository.ICursoRepository;
import ar.edu.unju.fi.repotp5.services.ICursoService;

@Service(value = "cursoServiceMysql")
public class CursoServiceImpMysql implements ICursoService {

    @Autowired
    private ICursoRepository cursoRepository;

    @Override
    public void guardarCurso(Curso curso) {
        this.cursoRepository.save(curso);
    }

    @Override
    @Transactional
    public void eliminarCurso(int codigo) {
        
        this.cursoRepository.eliminarCurso(codigo);
    }

    @Override
    public List<Curso> getCursos() {
        
        return this.cursoRepository.findAll();
    }

    @Override
    public Curso getCurso(int codigo) {        
        return this.cursoRepository.findByCodigo(codigo);
    }

}
