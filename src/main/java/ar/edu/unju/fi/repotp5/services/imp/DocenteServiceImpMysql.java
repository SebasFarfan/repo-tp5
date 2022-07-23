package ar.edu.unju.fi.repotp5.services.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unju.fi.repotp5.entity.Docente;
import ar.edu.unju.fi.repotp5.repository.IDocenteRepository;
import ar.edu.unju.fi.repotp5.services.IDocenteService;

@Service(value = "docenteServiceMysql")
public class DocenteServiceImpMysql implements IDocenteService {

    @Autowired
    private IDocenteRepository docenteRepository;

    @Override
    public Docente obtenerDocentePorLegajo(int legajo) {        
        
        return docenteRepository.findByLegajo(legajo);
    }

    @Override
    public void guardarDocente(Docente docente) {
        docenteRepository.save(docente);        
    }

    @Override
    public void modificarDocente(Docente docente) {
        docenteRepository.save(docente);        
    }

    @Override
    @Transactional
    public void eliminarDocente(int legajo) {
        docenteRepository.deleteByLegajo(legajo);        
    }

    @Override
    public List<Docente> getDocentes() {
        
        return docenteRepository.findAll();
    }
    
}
