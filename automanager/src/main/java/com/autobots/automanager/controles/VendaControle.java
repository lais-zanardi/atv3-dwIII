package com.autobots.automanager.controles;

import com.autobots.automanager.entidades.Venda;
import com.autobots.automanager.modelos.AdicionadorLinkVenda;
import com.autobots.automanager.servicos.VendaServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendas")
public class VendaControle {
    @Autowired private VendaServico servico;
    @Autowired
    private AdicionadorLinkVenda adicionadorLink;

    @PostMapping("/cadastrar")
    public ResponseEntity<Venda> cadastrarVenda(@RequestBody Venda venda) {
        Venda salvo = servico.salvar(venda);
        adicionadorLink.adicionarLink(salvo);
        return new ResponseEntity<>(salvo, HttpStatus.CREATED);
    }

    @GetMapping("/obter")
    public ResponseEntity<List<Venda>> obterVendas() {
        List<Venda> vendas = servico.obterTodas();
        adicionadorLink.adicionarLink(vendas);
        return new ResponseEntity<>(vendas, HttpStatus.FOUND);
    }

    @GetMapping("/obter/{id}")
    public ResponseEntity<Venda> obterVenda(@PathVariable Long id) {
        Venda venda = servico.obterPorId(id);
        if (venda == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        adicionadorLink.adicionarLink(venda);
        return new ResponseEntity<>(venda, HttpStatus.FOUND);
    }

    @PutMapping("/atualizar")
    public ResponseEntity<Venda> atualizarVenda(@RequestBody Venda venda) {
        Venda atualizado = servico.atualizar(venda);
        if (atualizado == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        adicionadorLink.adicionarLink(atualizado);
        return new ResponseEntity<>(atualizado, HttpStatus.OK);
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<?> excluirVenda(@PathVariable Long id) {
        if (servico.obterPorId(id) == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        servico.excluir(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}