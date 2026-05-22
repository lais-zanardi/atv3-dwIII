package com.autobots.automanager.mapeador;
import com.autobots.automanager.dtos.requisicao.MercadoriaRequisicaoDTO;
import com.autobots.automanager.dtos.resposta.MercadoriaRespostaDTO;
import com.autobots.automanager.entidades.Mercadoria;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MercadoriaMapeador {
    MercadoriaMapeador INSTANCIA = Mappers.getMapper(MercadoriaMapeador.class);
    @Mapping(target = "id", ignore = true)
    Mercadoria requisicaoParaEntidade(MercadoriaRequisicaoDTO dto);
    MercadoriaRespostaDTO entidadeParaResposta(Mercadoria entidade);
}