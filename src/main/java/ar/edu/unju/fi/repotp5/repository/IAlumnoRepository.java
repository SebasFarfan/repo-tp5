package ar.edu.unju.fi.repotp5.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.repotp5.entity.Alumno;

@Repository
public interface IAlumnoRepository extends JpaRepository<Alumno, Long> {
    
    @Modifying
    @Query("delete from Alumno a where a.dni = ?1")
    public void deleteByDni(int dni);    

    // @Modifying
    // @Query("select a from Alumno a where a.dni = ?1")
    // public Optional<Alumno> findByDni(int dni);
    @Query("select a from Alumno a where a.dni = ?1")
    public List<Alumno> obtenerAlumno(int dni);

    public Alumno findByDni(int dni);
}
