package com.autobots.automanager.servicos;

import com.autobots.automanager.entidades.Usuario;
import com.autobots.automanager.entidades.Veiculo;
import com.autobots.automanager.modelos.VeiculoAtualizador;
import com.autobots.automanager.repositorios.UsuarioRepositorio;
import com.autobots.automanager.repositorios.VeiculoRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VeiculoServico {
     private VeiculoRepositorio repositorio;
     private UsuarioRepositorio usuarioRepositorio;
     private VeiculoAtualizador atualizador;

    public Veiculo salvar(Veiculo veiculo, Long idProprietario) {
        Usuario proprietario = usuarioRepositorio.findById(idProprietario).orElseThrow();
        veiculo.setProprietario(proprietario);
        return repositorio.save(veiculo);
    }
    public List<Veiculo> obterTodos() { return repositorio.findAll(); }
    public Veiculo obterPorId(Long id) { return repositorio.findById(id).orElse(null); }
    public Veiculo atualizar(Veiculo atualizacao) {
        Veiculo alvo = obterPorId(atualizacao.getId());
        if (alvo != null) {
            atualizador.atualizar(alvo, atualizacao);
            return repositorio.save(alvo);
        }
        return null;
    }
    public void excluir(Long id) { repositorio.deleteById(id); }
}