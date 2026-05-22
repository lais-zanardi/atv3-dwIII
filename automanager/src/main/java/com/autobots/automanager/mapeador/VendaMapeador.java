package com.autobots.automanager.mapeador;

import com.autobots.automanager.dtos.requisicao.VendaRequisicaoDTO;
import com.autobots.automanager.dtos.resposta.VendaRespostaDTO;
import com.autobots.automanager.entidades.Venda;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(
        componentModel = "spring",
        uses = {
                UsuarioMapeador.class,
                VeiculoMapeador.class,
                MercadoriaMapeador.class,
                ServicoMapeador.class
        }
)
public interface VendaMapeador {
    VendaMapeador INSTANCIA = Mappers.getMapper(VendaMapeador.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "dataCadastro", ignore = true)
    Venda requisicaoParaEntidade(VendaRequisicaoDTO dto);

    VendaRespostaDTO entidadeParaResposta(Venda entidade);
}