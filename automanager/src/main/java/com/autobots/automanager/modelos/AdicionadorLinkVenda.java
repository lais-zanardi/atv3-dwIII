package com.autobots.automanager.modelos;

import com.autobots.automanager.controles.VendaControle;
import com.autobots.automanager.entidades.Venda;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdicionadorLinkVenda implements AdicionadorLink<Venda> {
    @Override
    public void adicionarLink(List<Venda> lista) {
        for (Venda venda : lista) adicionarLink(venda);
    }

    @Override
    public void adicionarLink(Venda objeto) {
        objeto.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(VendaControle.class).obterVenda(objeto.getId())).withSelfRel());
        objeto.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(VendaControle.class).obterVendas()).withRel("vendas"));
        objeto.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(VendaControle.class).atualizarVenda(objeto)).withRel("atualizar"));
        objeto.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(VendaControle.class).excluirVenda(objeto.getId())).withRel("excluir"));
    }
}