package me.dio.devweek.domain.repository;

import me.dio.devweek.domain.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {

    public boolean existsBySigla(String sigla);
}
