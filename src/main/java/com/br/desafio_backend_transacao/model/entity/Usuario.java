package com.br.desafio_backend_transacao.model.entity;

import com.br.desafio_backend_transacao.dto.UsuarioDTO;
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

    private BigDecimal saldo;

    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoUsuario;

    public Usuario(UsuarioDTO data){
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.email = email;
        this.senha = senha;
        this.saldo = saldo;
    }
}
