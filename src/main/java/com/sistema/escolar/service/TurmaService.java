package com.sistema.escolar.service;

import com.sistema.escolar.model.Turma;
import com.sistema.escolar.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurmaService {

    @Autowired
    private TurmaRepository turmaRepository;

    public Turma salvar(Turma turma) {
        return turmaRepository.save(turma);
    }

    public Turma atualizar(Long idTurma, Turma turma) {
        Optional<Turma> turmaOptional = turmaRepository.findById(idTurma);
        if (turmaOptional.isPresent()) {
            Turma turmaAtualizada = turmaOptional.get();
            turmaAtualizada.setSerie(turma.getSerie());
            turmaAtualizada.setCodigo(turma.getCodigo());
            turmaAtualizada.setTurno(turma.getTurno());
            return turmaRepository.save(turmaAtualizada);
        }
        return null; // LANÇAR EXCEÇÃO
    }

    public void excluir(Long idTurma) {
        turmaRepository.deleteById(idTurma);
    }

    public List<Turma> listar() {
        return turmaRepository.findAll();
    }

    public Turma buscarPorId(Long idTurma) {
        return turmaRepository.findById(idTurma).orElse(null);
    }

}
