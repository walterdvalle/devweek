package me.dio.devweek.service;

import me.dio.devweek.domain.model.Aluno;

public interface AlunoService {

    Aluno findById(Long id);

    Aluno create(Aluno aluno) throws IllegalAccessException;

}
