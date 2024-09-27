package com.sistema.escolar.model;

import com.sistema.escolar.model.enums.Turno;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "disciplina")
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "serie", nullable = false)
    private String serie;

    @Column(name = "turno", nullable = false)
    @Enumerated(EnumType.STRING)
    private Turno turno;

    @DateTimeFormat(iso = ISO.TIME, pattern = "HH:mm")
    @Column(name = "horario_inicio", nullable = false)
    private LocalDateTime horarioInicio;

    @DateTimeFormat(iso = ISO.TIME, pattern = "HH:mm")
    @Column(name = "horario_final", nullable = false)
    private LocalDateTime horarioFinal;

    public Disciplina(String nome, String serie, Turno turno, LocalDateTime horarioInicio, LocalDateTime horarioFinal) {
        this.nome = nome;
        this.serie = serie;
        this.turno = turno;
        this.horarioInicio = horarioInicio;
        this.horarioFinal = horarioFinal;
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

}
