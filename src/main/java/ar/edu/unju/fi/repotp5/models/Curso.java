package ar.edu.unju.fi.repotp5.models;

import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Curso {
    @Min(value = 1000000, message = "El DNI debe ser mayor o igual a 1.000.000")
    private int codigo;
    @Size(min = 3, max = 100, message = "El título debe tener entre 3 y 100 caractéres")
    @NotEmpty(message = "El título no puede ser vacío")
    private String titulo;
    private String categoria;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private int cantidadHoras;
    private String movilidad;
    private Docente docente;


    public Curso() {
    }

    public Curso(int codigo, String titulo, String categoria, LocalDate fechaInicio, LocalDate fechaFin, int cantidadHoras, String movilidad, Docente docente) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.categoria = categoria;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.cantidadHoras = cantidadHoras;
        this.movilidad = movilidad;
        this.docente = docente;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
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

    public int getCantidadHoras() {
        return this.cantidadHoras;
    }

    public void setCantidadHoras(int cantidadHoras) {
        this.cantidadHoras = cantidadHoras;
    }

    public String getMovilidad() {
        return this.movilidad;
    }

    public void setMovilidad(String movilidad) {
        this.movilidad = movilidad;
    }

    public Docente getDocente() {
        return this.docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

}
