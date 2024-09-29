package com.sistema.escolar.repository;

import com.sistema.escolar.model.Coordenador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoordenadorRepository extends JpaRepository<Coordenador, Long> {

    List<Coordenador> findByNome(String nome);

}
