package me.dio.devweek.domain.dto;

import me.dio.devweek.domain.model.Aluno;
import me.dio.devweek.domain.model.Curso;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DevWeekMapper {

    DevWeekMapper INSTANCE = Mappers.getMapper(DevWeekMapper.class);

    Aluno alunoDTOToAluno(AlunoDTO alunoDTO);
    AlunoDTO alunoToAlunoDTO(Aluno aluno);

    Curso cursoDTOToCurso(CursoDTO cursoDTO);

    void updateAlunoFromDTO(AlunoDTO alunoDTO, @MappingTarget Aluno aluno);

}
