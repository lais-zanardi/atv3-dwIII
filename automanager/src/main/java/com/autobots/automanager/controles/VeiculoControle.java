package com.autobots.automanager.controles;

import com.autobots.automanager.entidades.Veiculo;
import com.autobots.automanager.modelos.AdicionadorLinkVeiculo;
import com.autobots.automanager.servicos.VeiculoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculos")
public class VeiculoControle {
    @Autowired
    private VeiculoServico servico;
    @Autowired private AdicionadorLinkVeiculo adicionadorLink;

    @PostMapping("/cadastrar/{idProprietario}")
    public ResponseEntity<Veiculo> cadastrarVeiculo(@RequestBody Veiculo veiculo, @PathVariable Long idProprietario) {
        Veiculo salvo = servico.salvar(veiculo, idProprietario);
        adicionadorLink.adicionarLink(salvo);
        return new ResponseEntity<>(salvo, HttpStatus.CREATED);
    }

    @GetMapping("/obter")
    public ResponseEntity<List<Veiculo>> obterVeiculos() {
        List<Veiculo> veiculos = servico.obterTodos();
        adicionadorLink.adicionarLink(veiculos);
        return new ResponseEntity<>(veiculos, HttpStatus.FOUND);
    }

    @GetMapping("/obter/{id}")
    public ResponseEntity<Veiculo> obterVeiculo(@PathVariable Long id) {
        Veiculo veiculo = servico.obterPorId(id);
        if (veiculo == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        adicionadorLink.adicionarLink(veiculo);
        return new ResponseEntity<>(veiculo, HttpStatus.FOUND);
    }

    @PutMapping("/atualizar")
    public ResponseEntity<Veiculo> atualizarVeiculo(@RequestBody Veiculo veiculo) {
        Veiculo atualizado = servico.atualizar(veiculo);
        if (atualizado == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        adicionadorLink.adicionarLink(atualizado);
        return new ResponseEntity<>(atualizado, HttpStatus.OK);
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<?> excluirVeiculo(@PathVariable Long id) {
        if (servico.obterPorId(id) == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        servico.excluir(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
