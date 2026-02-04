package com.br.desafio_backend_transacao.model.transaction;

import com.br.desafio_backend_transacao.model.entity.Usuario;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "transactions")
@Table(name = "transactions")
@Data
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
}
