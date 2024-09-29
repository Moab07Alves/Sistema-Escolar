package com.sistema.escolar.model;

import com.sistema.escolar.model.enums.Turno;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "turma")
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "serie", nullable = false)
    private String serie;

    @Column(name = "codigo", nullable = false)
    private String codigo;

    @Column(name = "turno", nullable = false)
    @Enumerated(EnumType.STRING)
    private Turno turno;

    @OneToMany(mappedBy = "turma")
    private List<Aluno> alunos;

    @ManyToMany
    @JoinTable(name = "turma_disciplina",
            joinColumns = @JoinColumn(name = "id_turma"),
            inverseJoinColumns = @JoinColumn(name = "id_disciplina"))
    private List<Disciplina> disciplinas;

    public Turma(String serie, String codigo, Turno turno) {
        this.serie = serie;
        this.codigo = codigo;
        this.turno = turno;
        this.disciplinas  = new ArrayList<>();
        this.alunos  = new ArrayList<>();
    }

    public Turma(String serie, Turno turno) {
        this.serie = serie;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Turma turma = (Turma) o;
        return Objects.equals(id, turma.id) && Objects.equals(serie, turma.serie) && Objects.equals(codigo, turma.codigo) && turno == turma.turno;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, serie, codigo, turno);
    }
}
