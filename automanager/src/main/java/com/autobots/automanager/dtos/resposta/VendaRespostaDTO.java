package com.autobots.automanager.dtos.resposta;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;
import java.time.LocalDateTime;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class VendaRespostaDTO extends RepresentationModel<VendaRespostaDTO> {
    private Long id;
    private LocalDateTime dataCadastro;
    private UsuarioRespostaDTO cliente;
    private UsuarioRespostaDTO funcionario;
    private VeiculoRespostaDTO veiculo;
    private List<MercadoriaRespostaDTO> mercadorias;
    private List<ServicoRespostaDTO> servicos;
    private Double valorTotal;
}