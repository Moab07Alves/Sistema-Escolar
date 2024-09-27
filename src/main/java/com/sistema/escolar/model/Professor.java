package com.sistema.escolar.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DiscriminatorValue("Professor")
public class Professor extends Usuario{

    @ManyToMany(mappedBy = "professores")
    private List<Disciplina> disciplinas;

}
