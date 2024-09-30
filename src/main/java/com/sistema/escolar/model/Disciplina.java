package com.sistema.escolar.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sistema.escolar.model.enums.Turno;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "disciplina")
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "serie", nullable = false)
    private String serie;

    @Column(name = "turno", nullable = false)
    @Enumerated(EnumType.STRING)
    private Turno turno;

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "HH:mm")
    @DateTimeFormat(iso = ISO.TIME, pattern = "HH:mm")
    @Column(name = "horario_inicio", nullable = false)
    private LocalTime horarioInicio;

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "HH:mm")
    @DateTimeFormat(iso = ISO.TIME, pattern = "HH:mm")
    @Column(name = "horario_final", nullable = false)
    private LocalTime horarioFinal;

    @JsonIgnore
    @ManyToMany(mappedBy = "disciplinas")
    private List<Turma> turmas;

    @ManyToMany
    @JoinTable(name = "disciplina_professor",
            joinColumns = @JoinColumn(name = "id_disciplina"),
            inverseJoinColumns = @JoinColumn(name = "id_professor"))
    private List<Professor> professores;

    public Disciplina(String nome, String serie, Turno turno, LocalTime horarioInicio, LocalTime horarioFinal) {
        this.nome = nome;
        this.serie = serie;
        this.turno = turno;
        this.horarioInicio = horarioInicio;
        this.horarioFinal = horarioFinal;
        this.turmas = new ArrayList<>();
        this.professores = new ArrayList<>();
    }

    public void adicionarTurma(Turma turma) {
        this.turmas.add(turma);
    }

    public void removeTurma(Turma turma) {
        this.turmas.remove(turma);
    }

    public void adicionarProfessor(Professor professor) {
        this.professores.add(professor);
    }

    public void removerProfessor(Professor professor) {
        this.professores.remove(professor);
    }

    @Override
    public String toString() {
        return "{\n" +
                "id : " + id+ ",\n" +
                "nome : " + nome + ",\n" +
                "serie : " + serie + ",\n" +
                "turno : " + turno + ",\n" +
                "horarioInicio : " + horarioInicio + ",\n" +
                "horarioFinal :" +  horarioFinal + "\n" +
                "}\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Disciplina that = (Disciplina) o;
        return Objects.equals(id, that.id) && Objects.equals(nome, that.nome) && Objects.equals(serie, that.serie) && turno == that.turno && Objects.equals(horarioInicio, that.horarioInicio) && Objects.equals(horarioFinal, that.horarioFinal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, serie, turno, horarioInicio, horarioFinal);
    }

}
