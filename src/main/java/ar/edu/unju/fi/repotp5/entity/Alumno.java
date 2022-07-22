package ar.edu.unju.fi.repotp5.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "ALUMNOS")
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alumno_id")
    private Long codigo;
    @NotNull(message = "Ingresar un número de DNI")
    @Min(value = 1000000, message = "El DNI debe ser mayor o igual a 1.000.000")    
    @Column
    private int dni;
    @Size(min = 3, max = 100, message = "El nombre tiene que tenr entre 3 y 100 caractéres")
    @NotEmpty(message = "En nombre no debe ser vacío")
    @Column
    private String nombre;
    @NotBlank(message = "El apellido no debe estar en blanco")
    @Column
    private String apellido;
    @NotEmpty(message = "El número de teléfono no debe estar vacío")
    @Column
    private String telefono;
    @NotEmpty @Email(message = "e-mail no valido")
    @Column
    private String email;
    

    public Alumno() {
    }

    public Alumno(int dni, String nombre, String apellido, String telefono, String email) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
    }


    public Long getCodigo() {
        return this.codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }


    public int getDni() {
        return this.dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
