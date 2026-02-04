package com.br.desafio_backend_transacao.service;

import com.br.desafio_backend_transacao.dto.TransacaoDTO;
import com.br.desafio_backend_transacao.model.entity.Usuario;
import com.br.desafio_backend_transacao.model.transaction.Transacao;
import com.br.desafio_backend_transacao.repository.TransacaoRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

@Service
public class TransacaoService {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private TransacaoRepository repository;

    @Autowired
    private RestTemplate restTemplate;

    public void criarTransacao(TransacaoDTO transacao) throws Exception {
        User remetente = (User) usuarioService.findById(transacao.remetente_id());
        User destinatario = (User) usuarioService.findById(transacao.destinatario_id());

        usuarioService.validarTransacao((Usuario) remetente, transacao.quantidade());

        if (!autorizarTransacao((Usuario) remetente, transacao.quantidade())){
            throw new Exception("Transação não autorizada");
        }

        Transacao novatransacao = new Transacao();
        novatransacao.setQuantidade(transacao.quantidade());
        novatransacao.setRemetente((Usuario) remetente);
        novatransacao.setDestinatario((Usuario) destinatario);
        novatransacao.setTimestamp(LocalDateTime.now());

        ((Usuario) remetente).setValor(((Usuario) remetente).getValor().subtract(transacao.quantidade()));
        ((Usuario) destinatario).setValor(((Usuario) destinatario).getValor().add(transacao.quantidade()));

        repository.save(novatransacao);
        usuarioService.editar((Usuario) remetente);
        usuarioService.editar((Usuario) destinatario);
    }

    public boolean autorizarTransacao(Usuario remetente, BigDecimal quantidade){
        ResponseEntity<Map> autorizacaoResponse = restTemplate.getForEntity("https://util.devi.tools/api/v2/authorize", Map.class);

        if (autorizacaoResponse.getStatusCode() == HttpStatus.OK){
            String message = (String)  autorizacaoResponse.getBody().get("message");
            return "Autorizado".equalsIgnoreCase(message);
        } else return false;
    }

}
