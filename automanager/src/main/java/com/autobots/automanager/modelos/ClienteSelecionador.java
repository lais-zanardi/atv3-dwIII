package com.autobots.automanager.modelos;

import java.util.List;

import org.springframework.stereotype.Component;

import com.autobots.automanager.entidades.Usuario;

@Component
public class ClienteSelecionador {
	public Usuario selecionar(List<Usuario> clientes, long id) {
		Usuario selecionado = null;
		for (Usuario cliente : clientes) {
			if (cliente.getId() == id) {
				selecionado = cliente;
			}
		}
		return selecionado;
	}
}