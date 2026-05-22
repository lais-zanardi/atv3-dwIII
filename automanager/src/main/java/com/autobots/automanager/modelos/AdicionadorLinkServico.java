package com.autobots.automanager.modelos;

import com.autobots.automanager.controles.ServicoControle;
import com.autobots.automanager.dtos.resposta.ServicoRespostaDTO;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdicionadorLinkServico implements AdicionadorLink<ServicoRespostaDTO> {

    @Override
    public void adicionarLink(List<ServicoRespostaDTO> lista) {
        for (ServicoRespostaDTO dto : lista) {
            adicionarLink(dto);
        }
    }

    @Override
    public void adicionarLink(ServicoRespostaDTO objeto) {
        objeto.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ServicoControle.class).obterServico(objeto.getId())).withSelfRel());
        objeto.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ServicoControle.class).obterServicos()).withRel("servicos"));
        objeto.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ServicoControle.class).excluirServico(objeto.getId())).withRel("excluir"));
    }
}