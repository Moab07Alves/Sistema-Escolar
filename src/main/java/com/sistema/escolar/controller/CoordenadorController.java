package com.sistema.escolar.controller;

import com.sistema.escolar.dto.TurmaDTO;
import com.sistema.escolar.model.Turma;
import com.sistema.escolar.service.CoordenadorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    //---------- DISCIPLINA ----------//

}
