package com.br.desafio_backend_transacao.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public record TransacaoDTO(BigDecimal quantidade, @JsonProperty("remetente") Long remetente_id, @JsonProperty("destinatario") Long destinatario_id) {

}
