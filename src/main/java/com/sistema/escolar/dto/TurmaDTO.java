package com.sistema.escolar.dto;

import com.sistema.escolar.model.enums.Turno;

public record TurmaDTO(String serie, String codigo, Turno turno) {
}
