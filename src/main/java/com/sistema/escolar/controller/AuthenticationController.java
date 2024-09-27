package com.sistema.escolar.controller;

import com.sistema.escolar.dto.AuthenticationDTO;
import com.sistema.escolar.dto.LoginResponseDTO;
import com.sistema.escolar.dto.RegisterDTO;
import com.sistema.escolar.model.Aluno;
import com.sistema.escolar.model.Coordenador;
import com.sistema.escolar.model.Professor;
import com.sistema.escolar.model.Usuario;
import com.sistema.escolar.model.enums.Role;
import com.sistema.escolar.repository.AlunoRepository;
import com.sistema.escolar.repository.CoordenadorRepository;
import com.sistema.escolar.repository.ProfessorReposiroty;
import com.sistema.escolar.repository.UsuarioRepository;
import com.sistema.escolar.service.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CoordenadorRepository coordenadorRepository;

    @Autowired
    private ProfessorReposiroty professorReposiroty;

    @Autowired
    private AlunoRepository alunoRepository;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO authenticationDTO) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(authenticationDTO.email(), authenticationDTO.senha());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((Usuario) auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO registerDTO) {
        if (this.usuarioRepository.findByEmail(registerDTO.email()) != null) return ResponseEntity.badRequest().build();
        String encryptedPassword = new BCryptPasswordEncoder().encode(registerDTO.senha());
        if (registerDTO.role().equals("Coordenador")) {
            coordenadorRepository.save(new Coordenador(registerDTO.nome(), registerDTO.email(), encryptedPassword));
        }
        else if (registerDTO.role().equals("Professor")) {
            professorReposiroty.save(new Professor(registerDTO.nome(), registerDTO.email(), encryptedPassword));
        }
        else {
            alunoRepository.save(new Aluno(registerDTO.nome(), registerDTO.email(), encryptedPassword));
        }
        return ResponseEntity.ok().build();
    }

}
