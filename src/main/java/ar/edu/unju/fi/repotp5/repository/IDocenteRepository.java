package ar.edu.unju.fi.repotp5.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import ar.edu.unju.fi.repotp5.entity.Docente;

public interface IDocenteRepository extends JpaRepository<Docente,Long> {
    
    public Docente findByLegajo(int legajo);

    @Modifying
    @Query("delete from Docente d where d.legajo = ?1")
    public void deleteByLegajo(int legajo);

    @Query("select d from Docente d order by d.legajo")
    public List<Docente> obtenerDocentesOrdenadosPorLejago();

    
}
