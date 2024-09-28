package com.sistema.escolar.dto;

import com.sistema.escolar.model.enums.Turno;

import java.time.LocalDateTime;

public record DisciplinaDTO(String nome, String serie, Turno turno, LocalDateTime horarioInicio,
                            LocalDateTime horarioFinal) {
}
