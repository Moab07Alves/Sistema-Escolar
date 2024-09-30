package com.sistema.escolar.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sistema.escolar.model.enums.Role;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DiscriminatorValue("Professor")
public class Professor extends Usuario{

    @JsonIgnore
    @ManyToMany(mappedBy = "professores")
    private List<Disciplina> disciplinas;

    public Professor(String nome, String email, String senha) {
        super(nome, email, senha, Role.PROFESSOR);
        this.disciplinas = new ArrayList<>();
    }

    public void adicionarDisciplina(Disciplina disciplina) {
        this.disciplinas.add(disciplina);
    }

    public void removerDisciplina(Disciplina disciplina) {
        this.disciplinas.remove(disciplina);
    }

}
