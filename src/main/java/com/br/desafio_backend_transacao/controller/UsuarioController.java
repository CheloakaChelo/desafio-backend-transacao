package com.br.desafio_backend_transacao.controller;

import com.br.desafio_backend_transacao.dto.UsuarioDTO;
import com.br.desafio_backend_transacao.model.entity.Usuario;
import com.br.desafio_backend_transacao.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping("/criar")
    public ResponseEntity<Usuario> criar(@RequestBody UsuarioDTO usuario){
        Usuario usuarioCriar = service.inserir(usuario);
        return new ResponseEntity<>(usuarioCriar, HttpStatus.OK);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Usuario>> listar() {
        List<Usuario> usuarioList = service.listar();
        return new ResponseEntity<>(usuarioList, HttpStatus.OK);
    }



}
