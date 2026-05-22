package com.autobots.automanager.servicos;

import com.autobots.automanager.entidades.Mercadoria;
import com.autobots.automanager.modelos.MercadoriaAtualizador;
import com.autobots.automanager.repositorios.MercadoriaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MercadoriaServico {

    @Autowired
    private MercadoriaRepositorio repositorio;

    @Autowired
    private MercadoriaAtualizador atualizador;

    public Mercadoria salvar(Mercadoria mercadoria) {
        return repositorio.save(mercadoria);
    }

    public List<Mercadoria> obterTodas() {
        return repositorio.findAll();
    }

    public Mercadoria obterPorId(Long id) {
        return repositorio.findById(id).orElse(null);
    }

    public Mercadoria atualizar(Mercadoria atualizacao) {
        Mercadoria alvo = obterPorId(atualizacao.getId());
        if (alvo != null) {
            atualizador.atualizar(alvo, atualizacao);
            return repositorio.save(alvo);
        }
        return null;
    }

    public void excluir(Long id) {
        repositorio.deleteById(id);
    }
}