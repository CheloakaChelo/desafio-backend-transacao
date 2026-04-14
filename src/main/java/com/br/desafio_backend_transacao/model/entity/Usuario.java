package com.br.desafio_backend_transacao.model.entity;

import com.br.desafio_backend_transacao.dto.UsuarioDTO;
import com.br.desafio_backend_transacao.model.TipoUsuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity(name = "usuarios")
@Table(name = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
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
        this.nome = data.nome();
        this.sobrenome = data.sobrenome();
        this.documento = data.documento();
        this.email = data.email();
        this.senha = data.senha();
        this.saldo = data.saldo();
        this.tipoUsuario = data.tipoUsuario();
    }
}
