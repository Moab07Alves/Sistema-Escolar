package com.sistema.escolar.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Aluno")
public class Aluno extends Usuario{
}
