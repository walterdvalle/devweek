package me.dio.devweek.service;

import me.dio.devweek.domain.model.Aluno;

public interface AlunoService {

    public Aluno findById(Long id);

    public Aluno create(Aluno aluno);

}
