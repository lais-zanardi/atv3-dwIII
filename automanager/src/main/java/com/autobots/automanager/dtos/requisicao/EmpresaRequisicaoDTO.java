package com.autobots.automanager.dtos.requisicao;

import lombok.Data;
import java.util.List;

@Data
public class EmpresaRequisicaoDTO {
    private String razaoSocial;
    private String nomeFantasia;
    private EnderecoRequisicaoDTO endereco;
    private List<TelefoneRequisicaoDTO> telefones;
}