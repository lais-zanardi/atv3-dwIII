package com.autobots.automanager.modelos;

import com.autobots.automanager.entidades.Venda;
import org.springframework.stereotype.Component;

@Component
public class VendaAtualizador {
    public void atualizar(Venda alvo, Venda atualizacao) {
        if (atualizacao != null) {
            if (atualizacao.getCliente() != null) alvo.setCliente(atualizacao.getCliente());
            if (atualizacao.getFuncionario() != null) alvo.setFuncionario(atualizacao.getFuncionario());
            if (atualizacao.getVeiculo() != null) alvo.setVeiculo(atualizacao.getVeiculo());
            if (atualizacao.getValorTotal() != null) alvo.setValorTotal(atualizacao.getValorTotal());
            if (atualizacao.getMercadorias() != null && !atualizacao.getMercadorias().isEmpty()) {
                alvo.getMercadorias().clear();
                alvo.getMercadorias().addAll(atualizacao.getMercadorias());
            }
            if (atualizacao.getServicos() != null && !atualizacao.getServicos().isEmpty()) {
                alvo.getServicos().clear();
                alvo.getServicos().addAll(atualizacao.getServicos());
            }
        }
    }
}