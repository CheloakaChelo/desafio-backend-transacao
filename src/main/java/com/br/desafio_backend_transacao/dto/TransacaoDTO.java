package com.br.desafio_backend_transacao.dto;


import java.math.BigDecimal;

public record TransacaoDTO(BigDecimal quantidade, Long remetente_id, Long destinatario_id) {
}
