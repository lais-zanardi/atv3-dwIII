package com.autobots.automanager.controles;

import com.autobots.automanager.entidades.Empresa;
import com.autobots.automanager.modelos.AdicionadorLinkEmpresa;
import com.autobots.automanager.servicos.EmpresaServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresas")
public class EmpresaControle {
    @Autowired
    private EmpresaServico servico;
    @Autowired private AdicionadorLinkEmpresa adicionadorLink;

    @PostMapping("/cadastrar")
    public ResponseEntity<Empresa> cadastrarEmpresa(@RequestBody Empresa empresa) {
        Empresa salvo = servico.salvar(empresa);
        adicionadorLink.adicionarLink(salvo);
        return new ResponseEntity<>(salvo, HttpStatus.CREATED);
    }

    @GetMapping("/obter")
    public ResponseEntity<List<Empresa>> obterEmpresas() {
        List<Empresa> empresas = servico.obterTodas();
        adicionadorLink.adicionarLink(empresas);
        return new ResponseEntity<>(empresas, HttpStatus.FOUND);
    }

    @GetMapping("/obter/{id}")
    public ResponseEntity<Empresa> obterEmpresa(@PathVariable Long id) {
        Empresa empresa = servico.obterPorId(id);
        if (empresa == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        adicionadorLink.adicionarLink(empresa);
        return new ResponseEntity<>(empresa, HttpStatus.FOUND);
    }

    @PutMapping("/atualizar")
    public ResponseEntity<Empresa> atualizarEmpresa(@RequestBody Empresa empresa) {
        Empresa atualizado = servico.atualizar(empresa);
        if (atualizado == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        adicionadorLink.adicionarLink(atualizado);
        return new ResponseEntity<>(atualizado, HttpStatus.OK);
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<?> excluirEmpresa(@PathVariable Long id) {
        if (servico.obterPorId(id) == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        servico.excluir(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}