package ar.edu.unju.fi.repotp5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.repotp5.entity.Curso;

@Repository
public interface ICursoRepository extends JpaRepository<Curso, Long> {
    
    public Curso findByCodigo(int codigo);

    @Modifying
    @Query("delete from Curso c where c.codigo = ?1")
    public void eliminarCurso(int codigo);

    
}
