package com.autobots.automanager.servicos;

import com.autobots.automanager.entidades.Servico;
import com.autobots.automanager.modelos.ServicoAtualizador;
import com.autobots.automanager.repositorios.ServicoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicoServico {
    @Autowired
    private ServicoRepositorio repositorio;
    @Autowired private ServicoAtualizador atualizador;

    public Servico salvar(Servico servico) { return repositorio.save(servico); }
    public List<Servico> obterTodos() { return repositorio.findAll(); }
    public Servico obterPorId(Long id) { return repositorio.findById(id).orElse(null); }
    public Servico atualizar(Servico atualizacao) {
        Servico alvo = obterPorId(atualizacao.getId());
        if (alvo != null) {
            atualizador.atualizar(alvo, atualizacao);
            return repositorio.save(alvo);
        }
        return null;
    }
    public void excluir(Long id) { repositorio.deleteById(id); }
}