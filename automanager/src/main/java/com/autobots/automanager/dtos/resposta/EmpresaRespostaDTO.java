package com.autobots.automanager.dtos.resposta;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;
import java.time.LocalDateTime;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class EmpresaRespostaDTO extends RepresentationModel<EmpresaRespostaDTO> {
    private Long id;
    private String razaoSocial;
    private String nomeFantasia;
    private LocalDateTime dataCadastro;
    private EnderecoRespostaDTO endereco;
    private List<TelefoneRespostaDTO> telefones;
}