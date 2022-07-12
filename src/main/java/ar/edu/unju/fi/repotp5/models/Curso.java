package ar.edu.unju.fi.repotp5.models;

import java.time.LocalDate;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
public class Curso {
    @Min(value = 1, message = "Ingresar un codigo mayor a 0")
    private int codigo;
    @Size(min = 3, max = 100, message = "El título debe tener entre 3 y 100 caractéres")
    @NotEmpty(message = "El título no puede ser vacío")
    private String titulo;
    @NotEmpty(message = "Debe elegir una categoría")
    private String categoria;
    @NotNull(message = "Debe ingresar una fecha")
    @FutureOrPresent(message = "La fecha debe ser de hoy en adelante")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaInicio;
    @NotNull(message = "Debe ingresar una fecha")
    @FutureOrPresent(message = "La fecha debe ser de hoy en adelante")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaFin;
    @Min(value = 1, message = "La cantidad de horas tiene que ser mayor o igual 1")
    private int cantidadHoras;
    @NotEmpty(message = "Debe elegir modalidad")
    private String modalidad;
    @NotNull(message = "Debe seleccionar un docente")    
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
        this.modalidad = movilidad;
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

    public String getModalidad() {
        return this.modalidad;
    }

    public void setModalidad(String movilidad) {
        this.modalidad = movilidad;
    }

    public Docente getDocente() {
        return this.docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

}
