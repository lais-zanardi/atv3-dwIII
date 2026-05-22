package com.autobots.automanager.controles;

import com.autobots.automanager.dtos.requisicao.EmpresaRequisicaoDTO;
import com.autobots.automanager.dtos.resposta.EmpresaRespostaDTO;
import com.autobots.automanager.entidades.Empresa;
import com.autobots.automanager.mapeador.EmpresaMapeador;
import com.autobots.automanager.modelos.AdicionadorLinkEmpresa;
import com.autobots.automanager.servicos.EmpresaServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/empresas")
public class EmpresaControle {

    @Autowired private EmpresaServico servico;
    @Autowired private EmpresaMapeador mapeador;
    @Autowired private AdicionadorLinkEmpresa adicionadorLink;

    @PostMapping("/cadastrar")
    public ResponseEntity<EmpresaRespostaDTO> cadastrarEmpresa(@RequestBody EmpresaRequisicaoDTO requisicao) {
        Empresa entidade = mapeador.requisicaoParaEntidade(requisicao);
        Empresa salva = servico.salvar(entidade);
        EmpresaRespostaDTO resposta = mapeador.entidadeParaResposta(salva);
        adicionadorLink.adicionarLink(resposta);
        return new ResponseEntity<>(resposta, HttpStatus.CREATED);
    }

    @GetMapping("/obter")
    public ResponseEntity<List<EmpresaRespostaDTO>> obterEmpresas() {
        List<Empresa> empresas = servico.obterTodas();
        List<EmpresaRespostaDTO> respostas = empresas.stream()
                .map(mapeador::entidadeParaResposta)
                .collect(Collectors.toList());
        adicionadorLink.adicionarLink(respostas);
        return new ResponseEntity<>(respostas, HttpStatus.FOUND);
    }

    @GetMapping("/obter/{id}")
    public ResponseEntity<EmpresaRespostaDTO> obterEmpresa(@PathVariable Long id) {
        Empresa empresa = servico.obterPorId(id);
        if (empresa == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        EmpresaRespostaDTO resposta = mapeador.entidadeParaResposta(empresa);
        adicionadorLink.adicionarLink(resposta);
        return new ResponseEntity<>(resposta, HttpStatus.FOUND);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<EmpresaRespostaDTO> atualizarEmpresa(@PathVariable Long id, @RequestBody EmpresaRequisicaoDTO requisicao) {
        Empresa atualizacao = mapeador.requisicaoParaEntidade(requisicao);
        atualizacao.setId(id);

        Empresa atualizada = servico.atualizar(atualizacao);
        if (atualizada == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        EmpresaRespostaDTO resposta = mapeador.entidadeParaResposta(atualizada);
        adicionadorLink.adicionarLink(resposta);
        return new ResponseEntity<>(resposta, HttpStatus.OK);
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<?> excluirEmpresa(@PathVariable Long id) {
        if (servico.obterPorId(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        servico.excluir(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}