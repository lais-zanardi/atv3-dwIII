package com.autobots.automanager.dtos.requisicao;

import com.autobots.automanager.enums.Perfil;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class UsuarioRequisicaoDTO {
        private String nome;
        private String nomeSocial;
        private Set<Perfil> perfis;
        private EnderecoRequisicaoDTO endereco;
        private List<DocumentoRequisicaoDTO> documentos;
        private List<TelefoneRequisicaoDTO> telefones;
        private List<CredencialRequisicaoDTO> credenciais;
}