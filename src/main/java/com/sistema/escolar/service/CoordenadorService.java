package com.sistema.escolar.service;

import com.sistema.escolar.model.Coordenador;
import com.sistema.escolar.model.Disciplina;
import com.sistema.escolar.model.Turma;
import com.sistema.escolar.repository.CoordenadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoordenadorService {

    @Autowired
    private CoordenadorRepository coordenadorRepository;

    @Autowired
    private TurmaService turmaService;

    @Autowired
    private DisciplinaService disciplinaService;

    //---------- COORDENADOR ----------//

    public void excluir(Long idCoordenador) {
        coordenadorRepository.deleteById(idCoordenador);
    }

    public List<Coordenador> listarCoordenador() {
        return coordenadorRepository.findAll();
    }

    public List<Coordenador> buscarCoordenadorPorNome(String nome) {
        return coordenadorRepository.findByNome(nome);
    }

    public Disciplina cadastrarDisciplinaEmTurma(Long idTurma, Long idDisciplina) {
        Turma turma = turmaService.buscarPorId(idTurma);
        Disciplina disciplina = disciplinaService.buscarPorId(idDisciplina);
        turma.adicionarDisciplina(disciplina);
        disciplina.adicionarTurma(turma);
        turmaService.salvar(turma);
        return disciplinaService.salvar(disciplina);
    }

    public void removerDisciplinaDeTurma( Long idTurma, Long idDisciplina) {
        Turma turma = turmaService.buscarPorId(idTurma);
        Disciplina disciplina = disciplinaService.buscarPorId(idDisciplina);
        turma.removerDisciplina(disciplina);
        disciplina.removeTurma(turma);
        turmaService.salvar(turma);
        disciplinaService.salvar(disciplina);
    }

    //---------- TURMA ----------//

    public Turma criarTurma(Turma turma) {
        return turmaService.salvar(turma);
    }

    public Turma atualizarTurma(Long idTurma, Turma turma) {
        return turmaService.atualizar(idTurma, turma);
    }

    public void removerTurma(Long idTurma) {
        turmaService.excluir(idTurma);
    }

    public List<Turma> listarTurmas() {
        return turmaService.listar();
    }

    public Turma buscarTurma(Long idTurma) {
        return turmaService.buscarPorId(idTurma);
    }

    //---------- DISCIPLINA ----------//

    public Disciplina criarDisciplina(Disciplina disciplina) {
        return disciplinaService.salvar(disciplina);
    }

    public Disciplina atualizarDisciplina(Long idDisciplina, Disciplina disciplina) {
        return disciplinaService.atualizar(idDisciplina, disciplina);
    }

    public void removerDisciplina(Long idDisciplina) {
        disciplinaService.excluir(idDisciplina);
    }

    public List<Disciplina> listarDisciplinas() {
        return disciplinaService.listar();
    }

    public Disciplina buscarDisciplina(Long idDisciplina) {
        return disciplinaService.buscarPorId(idDisciplina);
    }

}
