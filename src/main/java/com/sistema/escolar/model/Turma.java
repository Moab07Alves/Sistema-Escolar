package com.sistema.escolar.model;

import com.sistema.escolar.model.enums.Turno;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "turma")
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "serie", nullable = false)
    private String serie;

    @Column(name = "codigo", nullable = false)
    private String codigo;

    @Column(name = "turno", nullable = false)
    @Enumerated(EnumType.STRING)
    private Turno turno;

    public Turma(String serie, String codigo, Turno turno) {
        this.serie = serie;
        this.codigo = codigo;
        this.turno = turno;
    }

    @Override
    public String toString() {
        return "{\n" +
                "id : " + id + ",\n" +
                "serie : " + serie + ",\n" +
                "codigo : " + codigo + ",\n" +
                "turno : " + turno + "\n" +
                "}\n";
    }

}
