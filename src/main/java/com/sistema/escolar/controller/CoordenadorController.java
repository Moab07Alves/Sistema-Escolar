package com.sistema.escolar.controller;

import com.sistema.escolar.dto.DisciplinaDTO;
import com.sistema.escolar.dto.TurmaDTO;
import com.sistema.escolar.model.Disciplina;
import com.sistema.escolar.model.Turma;
import com.sistema.escolar.service.CoordenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coordenador")
public class CoordenadorController {

    @Autowired
    private CoordenadorService coordenadorService;

    //---------- COORDENADOR ----------//



    //---------- TURMA ----------//

    @PostMapping("/turma/criar")
    public ResponseEntity<Turma> criarTurma(@RequestBody TurmaDTO turmaDTO) {
       Turma turma = coordenadorService.criarTurma(new Turma(turmaDTO.serie(), turmaDTO.codigo(), turmaDTO.turno()));
       return ResponseEntity.ok(turma);
    }

    @PutMapping("/turma/atualizar/{idTurma}")
    public ResponseEntity<Turma> atualizarTurma(@PathVariable("idTurma") Long idTurma, @RequestBody TurmaDTO turmaDTO) {
        Turma turma = coordenadorService.atualizarTurma(idTurma, new Turma(turmaDTO.serie(), turmaDTO.codigo(), turmaDTO.turno()));
        return ResponseEntity.ok(turma);
    }

    @DeleteMapping("/turma/excluir/{idTurma}")
    public ResponseEntity<?> excluirTurma(@PathVariable("idTurma") Long idTurma) {
        coordenadorService.removerTurma(idTurma);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/turma/listar")
    public ResponseEntity<List<Turma>> listarTurmas() {
        return ResponseEntity.ok(coordenadorService.listarTurmas());
    }

    @GetMapping("/turma/buscar/{idTurma}")
    public ResponseEntity<Turma> buscarTurmaPorId(@PathVariable("idTurma") Long idTurma) {
        return ResponseEntity.ok(coordenadorService.buscarTurma(idTurma));
    }

    //---------- DISCIPLINA ----------//

    @PostMapping("/disciplina/criar")
    public ResponseEntity<Disciplina> criarDisciplina(@RequestBody DisciplinaDTO disciplinaDTO) {
        Disciplina disciplina = coordenadorService.criarDisciplina(new Disciplina(disciplinaDTO.nome(), disciplinaDTO.serie(), disciplinaDTO.turno(), disciplinaDTO.horarioInicio(), disciplinaDTO.horarioFinal()));
        return ResponseEntity.ok(disciplina);
    }

    @PutMapping("/disciplina/atualizar/{idDisciplina}")
    public ResponseEntity<Disciplina> atualizarDisciplina(@PathVariable("idDisciplina") Long idDisciplina, @RequestBody DisciplinaDTO disciplinaDTO) {
        Disciplina disciplina = coordenadorService.atualizarDisciplina(idDisciplina, new Disciplina(disciplinaDTO.nome(), disciplinaDTO.serie(), disciplinaDTO.turno(), disciplinaDTO.horarioInicio(), disciplinaDTO.horarioFinal()));
        return ResponseEntity.ok(disciplina);
    }

    @DeleteMapping("/disciplina/excluir/{idDisciplina}")
    public ResponseEntity<?> excluirDisciplina(@PathVariable("idDisciplina") Long idDisciplina) {
        coordenadorService.removerDisciplina(idDisciplina);
        return ResponseEntity.ok().build();
    }

}
