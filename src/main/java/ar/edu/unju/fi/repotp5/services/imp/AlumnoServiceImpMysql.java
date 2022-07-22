package ar.edu.unju.fi.repotp5.services.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unju.fi.repotp5.entity.Alumno;
import ar.edu.unju.fi.repotp5.repository.IAlumnoRepository;
import ar.edu.unju.fi.repotp5.services.IAlumnoService;

@Service("alumnoServiceMysql")
public class AlumnoServiceImpMysql implements IAlumnoService {

    @Autowired
    IAlumnoRepository alumnoRepository;

    @Override
    public Alumno getAlumno() {
        
        return null;
    }

    @Override
    public boolean guardarAlumno(Alumno alumno) {
        boolean resultado = false;
        if (alumnoRepository.save(alumno)!=null) {
            resultado=true;            
        }
        return resultado;
    }

    @Override
    public void modificarAlumno(Alumno alumno) {
        alumnoRepository.save(alumno);
        
    }

    @Override
    @Transactional
    public boolean eliminarAlumno(int dni) {
        alumnoRepository.deleteByDni(dni);
        return true;
    }

    @Override
    public List<Alumno> getAlumnos() {
        
        return alumnoRepository.findAll();
    }

    @Override
    public Alumno buscarAlumno(int dni) {
        // Alumno alumno = alumnoRepository.obtenerAlumno(dni).get(0);
        Alumno alumno = alumnoRepository.findByDni(dni);
        return alumno;
    }
    
}
