package com.sistema.escolar.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DiscriminatorValue("Aluno")
public class Aluno extends Usuario{

    @Column(name = "serie", nullable = false)
    private String serie;

    @ManyToOne
    @JoinColumn(name = "fk_turma")
    private Turma turma;

}
