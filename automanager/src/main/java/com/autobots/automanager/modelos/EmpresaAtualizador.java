package com.autobots.automanager.modelos;

import com.autobots.automanager.entidades.Empresa;
import org.springframework.stereotype.Component;

@Component
public class EmpresaAtualizador {
    private StringVerificadorNulo verificador = new StringVerificadorNulo();
    public void atualizar(Empresa alvo, Empresa atualizacao) {
        if (atualizacao != null) {
            if (!verificador.verificar(atualizacao.getRazaoSocial())) alvo.setRazaoSocial(atualizacao.getRazaoSocial());
            if (!verificador.verificar(atualizacao.getNomeFantasia())) alvo.setNomeFantasia(atualizacao.getNomeFantasia());
        }
    }
}