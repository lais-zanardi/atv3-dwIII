package com.autobots.automanager.modelos;

import com.autobots.automanager.controles.ServicoControle;
import com.autobots.automanager.entidades.Servico;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdicionadorLinkServico implements AdicionadorLink<Servico> {
    @Override
    public void adicionarLink(List<Servico> lista) {
        for (Servico servico : lista) adicionarLink(servico);
    }

    @Override
    public void adicionarLink(Servico objeto) {
        objeto.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ServicoControle.class).obterServico(objeto.getId())).withSelfRel());
        objeto.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ServicoControle.class).obterServicos()).withRel("servicos"));
        objeto.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ServicoControle.class).atualizarServico(objeto)).withRel("atualizar"));
        objeto.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ServicoControle.class).excluirServico(objeto.getId())).withRel("excluir"));
    }
}
