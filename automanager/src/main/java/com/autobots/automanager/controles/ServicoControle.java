package com.autobots.automanager.controles;

import com.autobots.automanager.entidades.Servico;
import com.autobots.automanager.modelos.AdicionadorLinkServico;
import com.autobots.automanager.servicos.ServicoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicos")
public class ServicoControle {
    @Autowired private ServicoServico servicoServico;
    @Autowired
    private AdicionadorLinkServico adicionadorLink;

    @PostMapping("/cadastrar")
    public ResponseEntity<Servico> cadastrarServico(@RequestBody Servico servico) {
        Servico salvo = servicoServico.salvar(servico);
        adicionadorLink.adicionarLink(salvo);
        return new ResponseEntity<>(salvo, HttpStatus.CREATED);
    }

    @GetMapping("/obter")
    public ResponseEntity<List<Servico>> obterServicos() {
        List<Servico> servicos = servicoServico.obterTodos();
        adicionadorLink.adicionarLink(servicos);
        return new ResponseEntity<>(servicos, HttpStatus.FOUND);
    }

    @GetMapping("/obter/{id}")
    public ResponseEntity<Servico> obterServico(@PathVariable Long id) {
        Servico servico = servicoServico.obterPorId(id);
        if (servico == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        adicionadorLink.adicionarLink(servico);
        return new ResponseEntity<>(servico, HttpStatus.FOUND);
    }

    @PutMapping("/atualizar")
    public ResponseEntity<Servico> atualizarServico(@RequestBody Servico servico) {
        Servico atualizado = servicoServico.atualizar(servico);
        if (atualizado == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        adicionadorLink.adicionarLink(atualizado);
        return new ResponseEntity<>(atualizado, HttpStatus.OK);
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<?> excluirServico(@PathVariable Long id) {
        if (servicoServico.obterPorId(id) == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        servicoServico.excluir(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}