package com.sistema.escolar.dto;

import com.sistema.escolar.model.enums.Turno;

import java.time.LocalTime;

public record DisciplinaDTO(String nome, String serie, Turno turno, LocalTime horarioInicio,
                            LocalTime horarioFinal) {
}
