package ar.edu.unju.fi.repotp5.services.imp;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.fi.repotp5.entity.Alumno;
import ar.edu.unju.fi.repotp5.services.IAlumnoService;
import ar.edu.unju.fi.repotp5.util.ListaAlumnos;

@Service("AlumnoServiceImp")
public class AlumnoServiceImp implements IAlumnoService {

    private List<Alumno> alumnos;

    @Override
    public Alumno getAlumno() {        
        return null;
    }

    @Override
    public boolean guardarAlumno(Alumno alumno) {
        // this.alumnos = ListaAlumnos.alumnos;        
        return ListaAlumnos.alumnos.add(alumno);
    }

    @Override
    public void modificarAlumno(Alumno alumno) {
        for (Alumno alu : ListaAlumnos.alumnos) {
            if (alu.getDni() == alumno.getDni()) {
                alu.setApellido(alumno.getApellido());
                alu.setNombre(alumno.getNombre());
                alu.setEmail(alumno.getEmail());
                alu.setTelefono(alumno.getTelefono());
                break;
            }
        }
        
    }

    @Override
    public boolean eliminarAlumno(int dni) {
        boolean eliminado = false;
        Alumno alumnoBuscado = buscarAlumno(dni);
        if (alumnoBuscado != null) {
            eliminado = ListaAlumnos.alumnos.remove(alumnoBuscado);
        } 
        return eliminado;
    }

    @Override
    public List<Alumno> getAlumnos() {
        this.alumnos = ListaAlumnos.alumnos;
        return this.alumnos;
    }

    @Override
    public Alumno buscarAlumno(int dni) {
        Alumno alumno = ListaAlumnos.alumnos.stream().filter(a->a.getDni()==dni).findFirst().orElse(null);
        return alumno;
    }
    
}
