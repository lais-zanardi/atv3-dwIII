package com.autobots.automanager.modelos;

import com.autobots.automanager.controles.MercadoriaControle;
import com.autobots.automanager.entidades.Mercadoria;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdicionadorLinkMercadoria implements AdicionadorLink<Mercadoria> {
    @Override
    public void adicionarLink(List<Mercadoria> lista) {
        for (Mercadoria mercadoria : lista) adicionarLink(mercadoria);
    }

    @Override
    public void adicionarLink(Mercadoria objeto) {
        objeto.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(MercadoriaControle.class).obterMercadoria(objeto.getId())).withSelfRel());
        objeto.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(MercadoriaControle.class).obterMercadorias()).withRel("mercadorias"));
        objeto.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(MercadoriaControle.class).atualizarMercadoria(objeto)).withRel("atualizar"));
        objeto.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(MercadoriaControle.class).excluirMercadoria(objeto.getId())).withRel("excluir"));
    }
}