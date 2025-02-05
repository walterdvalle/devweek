package me.dio.devweek.service;

import me.dio.devweek.domain.dto.AlunoDTO;

public interface AlunoService {

    AlunoDTO findById(Long id);

    AlunoDTO create(AlunoDTO alunoDto) throws IllegalAccessException;

}
