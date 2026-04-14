package com.br.desafio_backend_transacao.model.transaction;

import com.br.desafio_backend_transacao.dto.TransacaoDTO;
import com.br.desafio_backend_transacao.model.entity.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "transactions")
@Table(name = "transactions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal quantidade;

    @ManyToOne
    @JoinColumn(name = "id_remetente")
    private Usuario remetente;

    @ManyToOne
    @JoinColumn(name = "id_destinatario")
    private Usuario destinatario;

    private LocalDateTime timestamp;

    public Transacao(TransacaoDTO data, Usuario remetente, Usuario destinatario){
        this.quantidade = data.quantidade();
        this.remetente = remetente;
        this.destinatario = destinatario;
        this.timestamp = LocalDateTime.now();
    }
}
