package com.sistema.escolar.service;

import com.sistema.escolar.model.Turma;
import com.sistema.escolar.repository.CoordenadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoordenadorService {

    @Autowired
    private CoordenadorRepository coordenadorRepository;

    @Autowired
    private TurmaService turmaService;

    //---------- COORDENADOR ----------//



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


}
