package com.autobots.automanager.modelos;

import com.autobots.automanager.entidades.Veiculo;
import org.springframework.stereotype.Component;

@Component
    public class VeiculoAtualizador {
        private StringVerificadorNulo verificador = new StringVerificadorNulo();
        public void atualizar(Veiculo alvo, Veiculo atualizacao) {
            if (atualizacao != null) {
                if (!verificador.verificar(atualizacao.getPlaca())) alvo.setPlaca(atualizacao.getPlaca());
                if (!verificador.verificar(atualizacao.getModelo())) alvo.setModelo(atualizacao.getModelo());
                if (!verificador.verificar(atualizacao.getMarca())) alvo.setMarca(atualizacao.getMarca());
                if (atualizacao.getAno() != null) alvo.setAno(atualizacao.getAno());
            }
        }
    }

