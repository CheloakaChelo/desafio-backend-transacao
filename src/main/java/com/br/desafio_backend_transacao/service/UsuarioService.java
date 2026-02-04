package com.br.desafio_backend_transacao.service;

import com.br.desafio_backend_transacao.dto.UsuarioDTO;
import com.br.desafio_backend_transacao.model.TipoUsuario;
import com.br.desafio_backend_transacao.model.entity.Usuario;
import com.br.desafio_backend_transacao.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public List<Usuario> listar() {
        return (List<Usuario>) repository.findAll();
    }

    public Usuario findById(@PathVariable Long id) throws Exception {
        return repository.findUsuarioById(id).orElseThrow(() -> new Exception("não foi possível encontrar o usuário"));
    }

    public Usuario findByDocumento(@PathVariable String documento) throws Exception {
        return repository.findUsuarioByDocumento(documento).orElseThrow(() -> new Exception("não foi possível encontrar o usuário"));
    }

    public Usuario inserir(UsuarioDTO data){
        Usuario novoUsuario = new Usuario(data);
        repository.save(novoUsuario);
        return novoUsuario;
    }

    public Usuario editar(@RequestBody Usuario usuario){
        Usuario usuarioEdit = repository.save(usuario);
        return usuarioEdit;
    }

    public Optional<Usuario> deletar(@PathVariable Long id){
        Optional<Usuario> usuarioDelete = repository.findById(id);
        repository.deleteById(id);
        return usuarioDelete;
    }

    public void validarTransacao(Usuario remetente, BigDecimal quantidade) throws Exception {
        if (remetente.getTipoUsuario() == TipoUsuario.MERCHANT){
            throw new Exception("O lojista não possui autorização para realizar transações");
        }

        if (remetente.getSaldo().compareTo(quantidade) < 0){
            throw new Exception("saldo insuficiente");
        }
    }
}
