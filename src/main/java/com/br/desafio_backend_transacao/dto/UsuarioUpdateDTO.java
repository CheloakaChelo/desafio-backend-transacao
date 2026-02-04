package com.br.desafio_backend_transacao.dto;

import java.math.BigDecimal;

public record UsuarioUpdateDTO(String nome, String senha, BigDecimal saldo) {
}
