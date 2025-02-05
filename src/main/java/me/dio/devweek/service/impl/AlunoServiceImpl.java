package me.dio.devweek.service.impl;

import me.dio.devweek.domain.model.Aluno;
import me.dio.devweek.domain.repository.AlunoRepository;
import me.dio.devweek.service.AlunoService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AlunoServiceImpl implements AlunoService {

    private final AlunoRepository alunoRepository;

    public AlunoServiceImpl(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    @Override
    public Aluno findById(Long id) {
        return alunoRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Aluno create(Aluno aluno) throws IllegalAccessException {
        if (alunoRepository.existsById(aluno.getId())) {
            throw new IllegalAccessException("Já existe uma aluno com esse id");
        }
        if (alunoRepository.existsByNumMatricula(aluno.getNumMatricula())) {
            throw new IllegalAccessException("Já existe uma aluno com essa matrícula");
        }
        return alunoRepository.save(aluno);
    }

 }
