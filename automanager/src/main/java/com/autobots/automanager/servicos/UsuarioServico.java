package com.autobots.automanager.servicos;

import com.autobots.automanager.entidades.Usuario;
import com.autobots.automanager.modelos.UsuarioAtualizador;
import com.autobots.automanager.repositorios.UsuarioRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioServico {
     private UsuarioRepositorio repositorio;
     private UsuarioAtualizador atualizador;

    public Usuario salvar(Usuario usuario) { return repositorio.save(usuario); }
    public List<Usuario> obterTodos() { return repositorio.findAll(); }
    public Usuario obterPorId(Long id) { return repositorio.findById(id).orElse(null); }
    public Usuario atualizar(Usuario atualizacao) {
        Usuario alvo = obterPorId(atualizacao.getId());
        if (alvo != null) {
            atualizador.atualizar(alvo, atualizacao);
            return repositorio.save(alvo);
        }
        return null;
    }
    public void excluir(Long id) { repositorio.deleteById(id); }
}