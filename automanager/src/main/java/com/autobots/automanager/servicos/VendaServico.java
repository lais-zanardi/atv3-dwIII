package com.autobots.automanager.servicos;

import com.autobots.automanager.entidades.Venda;
import com.autobots.automanager.modelos.VendaAtualizador;
import com.autobots.automanager.repositorios.VendaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendaServico {
    @Autowired private VendaRepositorio repositorio;
    @Autowired
    private VendaAtualizador atualizador;

    public Venda salvar(Venda venda) { return repositorio.save(venda); }
    public List<Venda> obterTodas() { return repositorio.findAll(); }
    public Venda obterPorId(Long id) { return repositorio.findById(id).orElse(null); }
    public Venda atualizar(Venda atualizacao) {
        Venda alvo = obterPorId(atualizacao.getId());
        if (alvo != null) {
            atualizador.atualizar(alvo, atualizacao);
            return repositorio.save(alvo);
        }
        return null;
    }
    public void excluir(Long id) { repositorio.deleteById(id); }
}