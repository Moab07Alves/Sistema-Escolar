package com.sistema.escolar.model;

import com.sistema.escolar.model.enums.Role;
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

    @Column(name = "serie")
    private String serie;

    @ManyToOne
    @JoinColumn(name = "fk_turma")
    private Turma turma;

    public Aluno(String nome, String email, String senha) {
        super(nome, email, senha, Role.ALUNO);
    }

}
