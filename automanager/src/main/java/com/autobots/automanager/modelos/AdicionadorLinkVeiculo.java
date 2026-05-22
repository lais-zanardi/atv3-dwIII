package com.autobots.automanager.modelos;

import com.autobots.automanager.controles.VeiculoControle;
import com.autobots.automanager.entidades.Veiculo;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdicionadorLinkVeiculo implements AdicionadorLink<Veiculo> {
    @Override
    public void adicionarLink(List<Veiculo> lista) {
        for (Veiculo veiculo : lista) adicionarLink(veiculo);
    }
    @Override
    public void adicionarLink(Veiculo objeto) {
        objeto.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(VeiculoControle.class).obterVeiculo(objeto.getId())).withSelfRel());
        objeto.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(VeiculoControle.class).obterVeiculos()).withRel("veiculos"));
        objeto.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(VeiculoControle.class).atualizarVeiculo(objeto)).withRel("atualizar"));
        objeto.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(VeiculoControle.class).excluirVeiculo(objeto.getId())).withRel("excluir"));
    }
}
