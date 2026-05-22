package com.autobots.automanager.modelos;

import com.autobots.automanager.entidades.Servico;
import org.springframework.stereotype.Component;

@Component
public class ServicoAtualizador {
    private StringVerificadorNulo verificador = new StringVerificadorNulo();

    public void atualizar(Servico alvo, Servico atualizacao) {
        if (atualizacao != null) {
            if (!verificador.verificar(atualizacao.getNome())) alvo.setNome(atualizacao.getNome());
            if (!verificador.verificar(atualizacao.getDescricao())) alvo.setDescricao(atualizacao.getDescricao());
            if (atualizacao.getValor() != null) alvo.setValor(atualizacao.getValor());
        }
    }
}