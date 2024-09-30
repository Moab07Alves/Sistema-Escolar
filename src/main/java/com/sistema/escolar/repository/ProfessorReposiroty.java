package com.sistema.escolar.repository;

import com.sistema.escolar.model.Disciplina;
import com.sistema.escolar.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessorReposiroty extends JpaRepository<Professor, Long> {

    @Query("SELECT d FROM Disciplina d JOIN d.professores p WHERE p.id = :professorId")
    List<Disciplina> findDisciplinasByProfessorId(@Param("professorId") Long professorId);

}
