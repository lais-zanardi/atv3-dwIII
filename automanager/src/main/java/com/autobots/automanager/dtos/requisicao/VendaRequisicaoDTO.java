package com.autobots.automanager.dtos.requisicao;

import lombok.Data;
import java.util.List;

@Data
public class VendaRequisicaoDTO {
    private UsuarioRequisicaoDTO cliente;
    private UsuarioRequisicaoDTO funcionario;
    private VeiculoRequisicaoDTO veiculo;
    private List<MercadoriaRequisicaoDTO> mercadorias;
    private List<ServicoRequisicaoDTO> servicos;
    private Double valorTotal;
}