package me.dio.devweek.domain.dto;

import me.dio.devweek.domain.model.Aluno;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DevweekMapper {

    DevweekMapper INSTANCE = Mappers.getMapper(DevweekMapper.class);

    Aluno alunoDTOToAluno(AlunoDTO alunoDTO);
    AlunoDTO alunoToAlunoDTO(Aluno aluno);

}
