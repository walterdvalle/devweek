package me.dio.devweek.service.impl;

import me.dio.devweek.domain.dto.AlunoDTO;
import me.dio.devweek.domain.dto.DevWeekMapper;
import me.dio.devweek.domain.model.Aluno;
import me.dio.devweek.domain.repository.AlunoRepository;
import me.dio.devweek.domain.repository.CursoRepository;
import me.dio.devweek.service.AlunoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class AlunoServiceImpl implements AlunoService {

    private final AlunoRepository alunoRepository;
    public final CursoRepository cursoRepository;

    public AlunoServiceImpl(AlunoRepository alunoRepository, CursoRepository cursoRepository) {
        this.alunoRepository = alunoRepository;
        this.cursoRepository = cursoRepository;
    }

    @Override
    public AlunoDTO findById(Long id) {
        Aluno aluno = alunoRepository.findById(id).orElseThrow(NoSuchElementException::new);
        return DevWeekMapper.INSTANCE.alunoToAlunoDTO(aluno);
    }

    @Override
    public AlunoDTO create(AlunoDTO alunoDTO) {
        if (alunoDTO.getId() != null && alunoRepository.existsById(alunoDTO.getId())) {
            throw new IllegalArgumentException("Já existe uma aluno com esse id");
        }
        if (alunoRepository.existsByNumMatricula(alunoDTO.getNumMatricula())) {
            throw new IllegalArgumentException("Já existe um aluno com essa matrícula");
        }
        if (alunoRepository.existsByLogin(alunoDTO.getLogin())) {
            throw new IllegalArgumentException("Já existe um aluno com esse login");
        }
        Aluno aluno = DevWeekMapper.INSTANCE.alunoDTOToAluno(alunoDTO);
        aluno.setCurso(cursoRepository.save(DevWeekMapper.INSTANCE.cursoDTOToCurso(alunoDTO.getCurso())));
        return DevWeekMapper.INSTANCE.alunoToAlunoDTO(alunoRepository.save(aluno));
    }

    @Override
    public List<AlunoDTO> findAll() {
        return alunoRepository.findAll().stream()
                .map(DevWeekMapper.INSTANCE::alunoToAlunoDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void update(Long id, AlunoDTO alunoDTO) {
        alunoRepository.findById(id)
                .map( aluno -> {
                    DevWeekMapper.INSTANCE.updateAlunoFromDTO(alunoDTO, aluno);
                    alunoRepository.save(aluno);
                    return "";
                }).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public void delete(Long id) {
        alunoRepository.findById(id)
                .map( aluno -> {
                    alunoRepository.delete(aluno);
                    return "";
                }).orElseThrow(NoSuchElementException::new);
    }
}
