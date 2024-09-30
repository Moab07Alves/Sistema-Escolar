package com.sistema.escolar.service;

import com.sistema.escolar.model.Disciplina;
import com.sistema.escolar.model.Professor;
import com.sistema.escolar.repository.ProfessorReposiroty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorReposiroty professorReposiroty;

    @Autowired
    private DisciplinaService disiplinaService;

    public Disciplina adicionarDisciplina(Long idProfessor, Long idDisciplina) {
        Professor professor = professorReposiroty.findById(idProfessor).get();
        Disciplina disciplina = disiplinaService.buscarPorId(idDisciplina);
        professor.adicionarDisciplina(disciplina);
        disciplina.adicionarProfessor(professor);
        professorReposiroty.save(professor);
        return disiplinaService.salvar(disciplina);
    }

    public void removerDisciplina(Long idProfessor, Long idDisciplina) {
        Professor professor = professorReposiroty.findById(idProfessor).get();
        Disciplina disciplina = disiplinaService.buscarPorId(idDisciplina);
        professor.removerDisciplina(disciplina);
        disciplina.removerProfessor(professor);
        professorReposiroty.save(professor);
        disiplinaService.salvar(disciplina);
    }

    public List<Disciplina> buscarDisciplinasMinistradas(Long idProfessor) {
        return professorReposiroty.findDisciplinasByProfessorId(idProfessor);
    }

}
