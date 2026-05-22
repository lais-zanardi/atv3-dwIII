

package com.autobots.automanager.mapeador;
import com.autobots.automanager.dtos.requisicao.ServicoRequisicaoDTO;
import com.autobots.automanager.dtos.resposta.ServicoRespostaDTO;
import com.autobots.automanager.entidades.Servico;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ServicoMapeador {
    ServicoMapeador INSTANCIA = Mappers.getMapper(ServicoMapeador.class);
    @Mapping(target = "id", ignore = true)
    Servico requisicaoParaEntidade(ServicoRequisicaoDTO dto);
    ServicoRespostaDTO entidadeParaResposta(Servico entidade);
}