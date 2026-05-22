package com.autobots.automanager.modelos;

import com.autobots.automanager.entidades.Usuario;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class AdicionadorLinkUsuario implements AdicionadorLink<Usuario> {
	@Override
	public void adicionarLink(List<Usuario> lista) {
		for (Usuario usuario : lista) adicionarLink(usuario);
	}
	@Override
	public void adicionarLink(Usuario objeto) {
		objeto.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UsuarioControle.class).obterUsuario(objeto.getId())).withSelfRel());
		objeto.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UsuarioControle.class).obterUsuarios()).withRel("usuarios"));
		objeto.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UsuarioControle.class).atualizarUsuario(objeto)).withRel("atualizar"));
		objeto.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UsuarioControle.class).excluirUsuario(objeto.getId())).withRel("excluir"));
	}
}