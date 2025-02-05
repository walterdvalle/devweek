package me.dio.devweek.domain.dto;

import java.util.List;

public class AlunoTurmaDTO {

    private Long id;
    private String login;
    private String nome;
    private String numMatricula;
    private CursoDTO curso;
    private List<MatriculaDTO> matriculas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumMatricula() {
        return numMatricula;
    }

    public void setNumMatricula(String numMatricula) {
        this.numMatricula = numMatricula;
    }

    public CursoDTO getCurso() {
        return curso;
    }

    public void setCurso(CursoDTO curso) {
        this.curso = curso;
    }

    public List<MatriculaDTO> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(List<MatriculaDTO> matriculas) {
        this.matriculas = matriculas;
    }
}
