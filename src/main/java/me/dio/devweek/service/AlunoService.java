package me.dio.devweek.service;

import me.dio.devweek.domain.dto.AlunoDTO;

import java.util.List;

public interface AlunoService {

    AlunoDTO findById(Long id);
    AlunoDTO create(AlunoDTO alunoDTO);
    List<AlunoDTO> findAll();
    AlunoDTO update(Long id, AlunoDTO alunoDTO);

}
