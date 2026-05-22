package com.autobots.automanager.modelos;

import com.autobots.automanager.controles.EmpresaControle;
import com.autobots.automanager.dtos.resposta.EmpresaRespostaDTO;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class AdicionadorLinkEmpresa implements AdicionadorLink<EmpresaRespostaDTO> {

    @Override
    public void adicionarLink(List<EmpresaRespostaDTO> lista) {
        for (EmpresaRespostaDTO dto : lista) {
            adicionarLink(dto);
        }
    }

    @Override
    public void adicionarLink(EmpresaRespostaDTO objeto) {
        objeto.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EmpresaControle.class).obterEmpresa(objeto.getId())).withSelfRel());
        objeto.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EmpresaControle.class).obterEmpresas()).withRel("empresas"));
        objeto.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EmpresaControle.class).excluirEmpresa(objeto.getId())).withRel("excluir"));
    }
}