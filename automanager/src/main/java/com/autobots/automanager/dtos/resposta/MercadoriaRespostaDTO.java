

package com.autobots.automanager.dtos.resposta;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;
@Data
@EqualsAndHashCode(callSuper = true)
public class MercadoriaRespostaDTO extends RepresentationModel<MercadoriaRespostaDTO> {
    private Long id;
    private String nome;
    private String descricao;
    private Double valor;
    private Integer quantidadeEstoque;
}