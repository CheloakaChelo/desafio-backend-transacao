package com.br.desafio_backend_transacao.controller;

import com.br.desafio_backend_transacao.dto.TransacaoDTO;
import com.br.desafio_backend_transacao.model.transaction.Transacao;
import com.br.desafio_backend_transacao.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    @Autowired
    private TransacaoService service;


    @PostMapping("/criar")
    public ResponseEntity<Transacao> criar(@RequestBody TransacaoDTO transacao) throws Exception{
        Transacao novaTransacao = this.service.criarTransacao(transacao);
        return new ResponseEntity<>(novaTransacao, HttpStatus.OK);

    }

}
