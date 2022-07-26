package ar.edu.unju.fi.repotp5.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "CURSOS")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "curso_id")
    private Long id;

    @Min(value = 1, message = "Ingresar un codigo mayor a 0")
    @Column(name = "curso_codigo")
    private int codigo;

    @Size(min = 3, max = 100, message = "El título debe tener entre 3 y 100 caractéres")
    @NotEmpty(message = "El título no puede ser vacío")
    @Column(name = "curso_titulo")
    private String titulo;

    @NotEmpty(message = "Debe elegir una categoría")
    @Column(name = "curso_categoria")
    private String categoria;

    @NotNull(message = "Debe ingresar una fecha")
    @FutureOrPresent(message = "La fecha debe ser de hoy en adelante")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "curso_fecha_inicio")
    private LocalDate fechaInicio;
    
    @NotNull(message = "Debe ingresar una fecha")
    @FutureOrPresent(message = "La fecha debe ser de hoy en adelante")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "curso_fecha_fin")
    private LocalDate fechaFin;

    @Min(value = 1, message = "La cantidad de horas tiene que ser mayor o igual 1")
    @Column(name = "curso_cantidad_horas")
    private int cantidadHoras;

    @NotEmpty(message = "Debe elegir modalidad")
    @Column(name = "curso_modalidad")
    private String modalidad;

    @NotNull(message = "Debe seleccionar un docente")
    @ManyToOne
    @JoinColumn(name = "docente_id")
    private Docente docente;

    @OneToMany(mappedBy = "curso")
    private List<Beca> becas;

    @ManyToMany
    @JoinTable(name = "curso_alumno",joinColumns = @JoinColumn(name="curso_id"),inverseJoinColumns = @JoinColumn(name="alumno_id"))
    private Set<Alumno> alumnos;


    public void addAlumnos(Alumno alumno) {
        if (this.alumnos == null) {
            this.alumnos = new HashSet<Alumno>();
        }
        this.alumnos.add(alumno);
    }


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


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
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


    public List<Beca> getBecas() {
        return this.becas;
    }

    public void setBecas(List<Beca> becas) {
        this.becas = becas;
    }

    public Set<Alumno> getAlumnos() {
        return this.alumnos;
    }

    public void setAlumnos(Set<Alumno> alumnos) {
        this.alumnos = alumnos;
    }


}
