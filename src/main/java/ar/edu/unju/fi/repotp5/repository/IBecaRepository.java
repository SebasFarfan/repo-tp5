package ar.edu.unju.fi.repotp5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.repotp5.entity.Beca;

@Repository
public interface IBecaRepository extends JpaRepository<Beca, Long> {
    
}
