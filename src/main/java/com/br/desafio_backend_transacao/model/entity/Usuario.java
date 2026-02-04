package com.br.desafio_backend_transacao.model.entity;

import com.br.desafio_backend_transacao.model.TipoUsuario;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Entity(name = "usuarios")
@Table(name = "usuarios")
@Data
@EqualsAndHashCode(of= "id")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    private String sobrenome;

    @Column(unique = true)
    private String documento;

    @Column(unique = true)
    private String email;

    private String senha;

    private BigDecimal valor;

    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoUsuario;
}
