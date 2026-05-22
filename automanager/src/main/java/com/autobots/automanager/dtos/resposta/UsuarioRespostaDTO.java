package com.autobots.automanager.dtos.resposta;

import com.autobots.automanager.enums.Perfil;
import org.springframework.hateoas.RepresentationModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
public class UsuarioRespostaDTO extends RepresentationModel<UsuarioRespostaDTO> {
    private Long id;
    private String nome;
    private String nomeSocial;
    private Set<Perfil> perfis;
    private EnderecoRespostaDTO endereco;
    private List<DocumentoRespostaDTO> documentos;
    private List<TelefoneRespostaDTO> telefones;
    private List<CredencialRespostaDTO> credenciais;
}