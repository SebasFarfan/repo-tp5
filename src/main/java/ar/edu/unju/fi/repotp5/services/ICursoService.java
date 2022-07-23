package ar.edu.unju.fi.repotp5.services;

import java.util.List;

import ar.edu.unju.fi.repotp5.entity.Curso;

public interface ICursoService {
    public void guardarCurso(Curso curso);
    public void eliminarCurso(int codigo);
    public List<Curso> getCursos();
    public Curso getCurso(int codigo);
}
