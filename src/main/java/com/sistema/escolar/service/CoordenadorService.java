package com.sistema.escolar.service;

import com.sistema.escolar.repository.CoordenadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CoordenadorService {

    @Autowired
    private CoordenadorRepository coordenadorRepository;

}
