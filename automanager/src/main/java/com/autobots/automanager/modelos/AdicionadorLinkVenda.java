package com.autobots.automanager.modelos;

import com.autobots.automanager.controles.VendaControle;
import com.autobots.automanager.dtos.resposta.VendaRespostaDTO;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdicionadorLinkVenda implements AdicionadorLink<VendaRespostaDTO> {

    @Override
    public void adicionarLink(List<VendaRespostaDTO> lista) {
        for (VendaRespostaDTO dto : lista) {
            adicionarLink(dto);
        }
    }

    @Override
    public void adicionarLink(VendaRespostaDTO objeto) {
        objeto.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(VendaControle.class).obterVenda(objeto.getId())).withSelfRel());
        objeto.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(VendaControle.class).obterVendas()).withRel("vendas"));
        objeto.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(VendaControle.class).excluirVenda(objeto.getId())).withRel("excluir"));
    }
}