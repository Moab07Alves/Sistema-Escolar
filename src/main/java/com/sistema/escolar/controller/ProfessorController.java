package com.sistema.escolar.controller;

import com.sistema.escolar.model.Disciplina;
import com.sistema.escolar.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @PostMapping("/adicionar/disciplina/{idDisciplina}")
    public ResponseEntity<Disciplina> adicionarDisciplinaMinistrada(@RequestParam("idUsuario") Long idUsuario, @PathVariable("idDisciplina") Long idDisciplina) {
        Disciplina disciplina = professorService.adicionarDisciplina(idUsuario, idDisciplina);
        return ResponseEntity.ok(disciplina);
    }

    @DeleteMapping("/remover/disciplina/{idDisciplina}")
    public ResponseEntity<?> removerDisciplinaMinistrada(@RequestParam("idUsuario") Long idUsuario, @PathVariable("idDisciplina") Long idDisciplina) {
        professorService.removerDisciplina(idUsuario, idDisciplina);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/listar/disciplinas")
    public ResponseEntity<List<Disciplina>> listarDisciplinas(@RequestParam("idUsuario") Long idUsuario) {
        return ResponseEntity.ok(professorService.buscarDisciplinasMinistradas(idUsuario));
    }

}
