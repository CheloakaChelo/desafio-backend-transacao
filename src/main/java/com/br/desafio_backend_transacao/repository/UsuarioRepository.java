package com.br.desafio_backend_transacao.repository;

import com.br.desafio_backend_transacao.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
    Optional<Usuario> findUsuarioById(Long id);

    Optional<Usuario> findUsuarioByDocumento(String documento);

}
