package com.br.desafio_backend_transacao.dto;

import java.math.BigDecimal;

public record UsuarioDTO(Long id, String nome, String sobrenome, String documento, String email, String senha, BigDecimal saldo) {
}
