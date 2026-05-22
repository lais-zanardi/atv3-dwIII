package com.autobots.automanager.modelos;

import com.autobots.automanager.entidades.Mercadoria;
import org.springframework.stereotype.Component;

@Component
public class MercadoriaAtualizador {
    private StringVerificadorNulo verificador = new StringVerificadorNulo();

    public void atualizar(Mercadoria alvo, Mercadoria atualizacao) {
        if (atualizacao != null) {
            if (!verificador.verificar(atualizacao.getNome())) alvo.setNome(atualizacao.getNome());
            if (!verificador.verificar(atualizacao.getDescricao())) alvo.setDescricao(atualizacao.getDescricao());
            if (atualizacao.getValor() != null) alvo.setValor(atualizacao.getValor());
            if (atualizacao.getQuantidadeEstoque() != null) alvo.setQuantidadeEstoque(atualizacao.getQuantidadeEstoque());
        }
    }
}