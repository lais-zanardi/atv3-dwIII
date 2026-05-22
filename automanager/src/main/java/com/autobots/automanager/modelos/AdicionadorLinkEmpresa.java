package com.autobots.automanager.modelos;

import com.autobots.automanager.controles.EmpresaControle;
import com.autobots.automanager.entidades.Empresa;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdicionadorLinkEmpresa implements AdicionadorLink<Empresa> {
    @Override
    public void adicionarLink(List<Empresa> lista) {
        for (Empresa empresa : lista) adicionarLink(empresa);
    }
    @Override
    public void adicionarLink(Empresa objeto) {
        objeto.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EmpresaControle.class).obterEmpresa(objeto.getId())).withSelfRel());
        objeto.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EmpresaControle.class).obterEmpresas()).withRel("empresas"));
        objeto.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EmpresaControle.class).atualizarEmpresa(objeto)).withRel("atualizar"));
        objeto.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EmpresaControle.class).excluirEmpresa(objeto.getId())).withRel("excluir"));
    }
}
