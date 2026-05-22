package com.autobots.automanager.modelos;

import com.autobots.automanager.controles.MercadoriaControle;
import com.autobots.automanager.dtos.resposta.MercadoriaRespostaDTO;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdicionadorLinkMercadoria implements AdicionadorLink<MercadoriaRespostaDTO> {

    @Override
    public void adicionarLink(List<MercadoriaRespostaDTO> lista) {
        for (MercadoriaRespostaDTO dto : lista) {
            adicionarLink(dto);
        }
    }

    @Override
    public void adicionarLink(MercadoriaRespostaDTO objeto) {
        objeto.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(MercadoriaControle.class).obterMercadoria(objeto.getId())).withSelfRel());
        objeto.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(MercadoriaControle.class).obterMercadorias()).withRel("mercadorias"));
        objeto.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(MercadoriaControle.class).excluirMercadoria(objeto.getId())).withRel("excluir"));
    }
}