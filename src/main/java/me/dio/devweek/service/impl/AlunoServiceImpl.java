package me.dio.devweek.service.impl;

import me.dio.devweek.domain.dto.AlunoDTO;
import me.dio.devweek.domain.dto.DevweekMapper;
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
    public AlunoDTO findById(Long id) {
        Aluno aluno = alunoRepository.findById(id).orElseThrow(NoSuchElementException::new);
        return DevweekMapper.INSTANCE.alunoToAlunoDTO(aluno);
    }

    @Override
    public AlunoDTO create(AlunoDTO alunoDTO) throws IllegalAccessException {
        if (alunoDTO.getId() != null && alunoRepository.existsById(alunoDTO.getId())) {
            throw new IllegalAccessException("Já existe uma aluno com esse id");
        }
        if (alunoRepository.existsByNumMatricula(alunoDTO.getNumMatricula())) {
            throw new IllegalAccessException("Já existe um aluno com essa matrícula");
        }
        Aluno aluno = DevweekMapper.INSTANCE.alunoDTOToAluno(alunoDTO);
        return DevweekMapper.INSTANCE.alunoToAlunoDTO(alunoRepository.save(aluno));
    }
 }
