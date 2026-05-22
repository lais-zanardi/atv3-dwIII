package com.autobots.automanager.dtos.requisicao;
import lombok.Data;
@Data
public class MercadoriaRequisicaoDTO {
    private String nome;
    private String descricao;
    private Double valor;
    private Integer quantidadeEstoque;
}