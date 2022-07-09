package ar.edu.unju.fi.repotp5.models;

import java.time.LocalDate;

public class Beca {
    private int codigo;
    private Curso curso;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String estado;


    public Beca() {
    }

    public Beca(int codigo, Curso curso, LocalDate fechaInicio, LocalDate fechaFin, String estado) {
        this.codigo = codigo;
        this.curso = curso;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Curso getCurso() {
        return this.curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public LocalDate getFechaInicio() {
        return this.fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return this.fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
