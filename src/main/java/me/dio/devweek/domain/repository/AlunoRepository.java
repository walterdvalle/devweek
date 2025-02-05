package me.dio.devweek.domain.repository;

import me.dio.devweek.domain.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    public boolean existsByMatricula(String matricula);

}
