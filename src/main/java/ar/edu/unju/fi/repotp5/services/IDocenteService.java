package ar.edu.unju.fi.repotp5.services;

import java.util.List;

import ar.edu.unju.fi.repotp5.entity.Docente;

public interface IDocenteService {
    public Docente obtenerDocentePorLegajo(int legajo);
    public void guardarDocente(Docente docente);
    public void modificarDocente(Docente docente);
    public void eliminarDocente(int legajo);
    public List<Docente> getDocentes();    
}
