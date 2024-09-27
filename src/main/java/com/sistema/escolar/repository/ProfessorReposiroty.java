package com.sistema.escolar.repository;

import com.sistema.escolar.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorReposiroty extends JpaRepository<Professor, Long> {
}
