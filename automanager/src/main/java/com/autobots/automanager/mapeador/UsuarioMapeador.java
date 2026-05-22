package com.autobots.automanager.mapeador;

import com.autobots.automanager.dtos.requisicao.UsuarioRequisicaoDTO;
import com.autobots.automanager.dtos.resposta.UsuarioRespostaDTO;
import com.autobots.automanager.entidades.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(
        componentModel = "spring",
        uses = {
                DocumentoMapeador.class,
                EnderecoMapeador.class,
                TelefoneMapeador.class,
                CredencialMapeador.class
        }
)
public interface UsuarioMapeador {
    UsuarioMapeador INSTANCIA = Mappers.getMapper(UsuarioMapeador.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "veiculos", ignore = true)
    Usuario requisicaoParaEntidade(UsuarioRequisicaoDTO dto);

    UsuarioRespostaDTO entidadeParaResposta(Usuario entidade);
}