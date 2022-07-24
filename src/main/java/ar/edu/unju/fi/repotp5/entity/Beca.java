package ar.edu.unju.fi.repotp5.entity;

import java.time.LocalDate;

// import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "BECAS")
public class Beca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "beca_id") 
    private Long codigo;

    @NotNull(message = "Debe elegir un curso")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id")    
    private Curso curso;

    @NotNull(message = "Debe ingresar una fecha")
    @FutureOrPresent(message = "La fecha debe ser de hoy en adelante")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column
    private LocalDate fechaInicio;

    @NotNull(message = "Debe ingresar una fecha")
    @FutureOrPresent(message = "La fecha debe ser de hoy en adelante")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column
    private LocalDate fechaFin;
    
    @Column
    private String estado;


    public Beca() {
    }

    public Beca(Long codigo, Curso curso, LocalDate fechaInicio, LocalDate fechaFin, String estado) {
        this.codigo = codigo;
        this.curso = curso;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
    }

    public Long getCodigo() {
        return this.codigo;
    }

    public void setCodigo(Long codigo) {
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
