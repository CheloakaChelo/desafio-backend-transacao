package com.br.desafio_backend_transacao.repository;

import com.br.desafio_backend_transacao.model.transaction.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
}
