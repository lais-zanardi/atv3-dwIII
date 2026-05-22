package com.autobots.automanager.modelos;

import com.autobots.automanager.controles.UsuarioControle;
import com.autobots.automanager.dtos.resposta.UsuarioRespostaDTO;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdicionadorLinkUsuario implements AdicionadorLink<UsuarioRespostaDTO> {

	@Override
	public void adicionarLink(List<UsuarioRespostaDTO> lista) {
		for (UsuarioRespostaDTO dto : lista) {
			adicionarLink(dto);
		}
	}

	@Override
	public void adicionarLink(UsuarioRespostaDTO objeto) {
		objeto.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UsuarioControle.class).obterUsuario(objeto.getId())).withSelfRel());
		objeto.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UsuarioControle.class).obterUsuarios()).withRel("usuarios"));
		objeto.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UsuarioControle.class).excluirUsuario(objeto.getId())).withRel("excluir"));
	}
}