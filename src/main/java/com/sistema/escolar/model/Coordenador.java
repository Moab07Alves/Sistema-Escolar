package com.sistema.escolar.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Coordenador")
public class Coordenador extends Usuario{
}
