package com.sistema.escolar.model;

import com.sistema.escolar.model.enums.Role;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@DiscriminatorValue("Coordenador")
public class Coordenador extends Usuario {

    public Coordenador(String nome, String email, String senha) {
        super(nome, email, senha, Role.COORDENADOR);
    }

}
