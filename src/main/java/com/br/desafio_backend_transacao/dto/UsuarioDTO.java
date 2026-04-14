package com.br.desafio_backend_transacao.dto;

import com.br.desafio_backend_transacao.model.TipoUsuario;
import lombok.Data;

import java.math.BigDecimal;

public record UsuarioDTO(Long id, String nome, String sobrenome, String documento, String email, String senha, BigDecimal saldo, TipoUsuario tipoUsuario) {
}
