package ar.edu.unju.fi.repotp5.services;

import java.util.List;

import ar.edu.unju.fi.repotp5.entity.Alumno;

public interface IAlumnoService {
    
    public Alumno getAlumno();
    public boolean guardarAlumno(Alumno alumno);
    public void modificarAlumno(Alumno alumno);
    public boolean eliminarAlumno(int dni);
    public List<Alumno> getAlumnos();
    public Alumno buscarAlumno(int dni);
    
}
