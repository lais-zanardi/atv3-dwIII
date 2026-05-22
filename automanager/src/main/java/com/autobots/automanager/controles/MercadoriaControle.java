package com.autobots.automanager.controles;

import com.autobots.automanager.entidades.Mercadoria;
import com.autobots.automanager.modelos.AdicionadorLinkMercadoria;
import com.autobots.automanager.servicos.MercadoriaServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mercadorias")
public class MercadoriaControle {
    @Autowired
    private MercadoriaServico servico;
    @Autowired private AdicionadorLinkMercadoria adicionadorLink;

    @PostMapping("/cadastrar")
    public ResponseEntity<Mercadoria> cadastrarMercadoria(@RequestBody Mercadoria mercadoria) {
        Mercadoria salvo = servico.salvar(mercadoria);
        adicionadorLink.adicionarLink(salvo);
        return new ResponseEntity<>(salvo, HttpStatus.CREATED);
    }

    @GetMapping("/obter")
    public ResponseEntity<List<Mercadoria>> obterMercadorias() {
        List<Mercadoria> mercadorias = servico.obterTodas();
        adicionadorLink.adicionarLink(mercadorias);
        return new ResponseEntity<>(mercadorias, HttpStatus.FOUND);
    }

    @GetMapping("/obter/{id}")
    public ResponseEntity<Mercadoria> obterMercadoria(@PathVariable Long id) {
        Mercadoria mercadoria = servico.obterPorId(id);
        if (mercadoria == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        adicionadorLink.adicionarLink(mercadoria);
        return new ResponseEntity<>(mercadoria, HttpStatus.FOUND);
    }

    @PutMapping("/atualizar")
    public ResponseEntity<Mercadoria> atualizarMercadoria(@RequestBody Mercadoria mercadoria) {
        Mercadoria atualizado = servico.atualizar(mercadoria);
        if (atualizado == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        adicionadorLink.adicionarLink(atualizado);
        return new ResponseEntity<>(atualizado, HttpStatus.OK);
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<?> excluirMercadoria(@PathVariable Long id) {
        if (servico.obterPorId(id) == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        servico.excluir(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}