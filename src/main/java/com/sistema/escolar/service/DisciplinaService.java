package com.sistema.escolar.service;

import com.sistema.escolar.model.Disciplina;
import com.sistema.escolar.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplinaService {

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    public Disciplina salvar(Disciplina disciplina) {
        return disciplinaRepository.save(disciplina);
    }

    public Disciplina atualizar(Long idDisciplina, Disciplina disciplina) {
        Optional<Disciplina> disciplinaOptional = disciplinaRepository.findById(idDisciplina);
        if (disciplinaOptional.isPresent()) {
            Disciplina disciplinaAtualizada = disciplinaOptional.get();
            disciplinaAtualizada.setNome(disciplina.getNome());
            disciplinaAtualizada.setSerie(disciplina.getSerie());
            disciplinaAtualizada.setTurno(disciplina.getTurno());
            disciplinaAtualizada.setHorarioInicio(disciplina.getHorarioInicio());
            disciplinaAtualizada.setHorarioFinal(disciplina.getHorarioFinal());
            return disciplinaRepository.save(disciplinaAtualizada);
        }
        return null; // LANÇAR EXCEÇÃO
    }

    public void excluir(Long idDisciplina) {
        disciplinaRepository.deleteById(idDisciplina);
    }

    public List<Disciplina> listar() {
        return disciplinaRepository.findAll();
    }

    public Disciplina buscarPorId(Long idDisciplina) {
        return disciplinaRepository.findById(idDisciplina).orElse(null);
    }

}
