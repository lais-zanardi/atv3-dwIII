package com.autobots.automanager.mapeador;

import com.autobots.automanager.dtos.requisicao.EmpresaRequisicaoDTO;
import com.autobots.automanager.dtos.resposta.EmpresaRespostaDTO;
import com.autobots.automanager.entidades.Empresa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {EnderecoMapeador.class, TelefoneMapeador.class})
public interface EmpresaMapeador {
    EmpresaMapeador INSTANCIA = Mappers.getMapper(EmpresaMapeador.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "dataCadastro", ignore = true)
    @Mapping(target = "usuarios", ignore = true)
    @Mapping(target = "mercadorias", ignore = true)
    @Mapping(target = "servicos", ignore = true)
    @Mapping(target = "vendas", ignore = true)
    Empresa requisicaoParaEntidade(EmpresaRequisicaoDTO dto);

    EmpresaRespostaDTO entidadeParaResposta(Empresa entidade);
}