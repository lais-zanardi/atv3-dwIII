package com.autobots.automanager.modelos;

import com.autobots.automanager.entidades.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioAtualizador {
	private StringVerificadorNulo verificador = new StringVerificadorNulo();
	public void atualizar(Usuario alvo, Usuario atualizacao) {
		if (atualizacao != null) {
			if (!verificador.verificar(atualizacao.getNome())) alvo.setNome(atualizacao.getNome());
			if (!verificador.verificar(atualizacao.getNomeSocial())) alvo.setNomeSocial(atualizacao.getNomeSocial());
			if (atualizacao.getPerfis() != null && !atualizacao.getPerfis().isEmpty()) {
				alvo.getPerfis().clear();
				alvo.getPerfis().addAll(atualizacao.getPerfis());
			}
		}
	}
}