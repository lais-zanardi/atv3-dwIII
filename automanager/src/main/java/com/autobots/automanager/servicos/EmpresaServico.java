package com.autobots.automanager.servicos;

import com.autobots.automanager.entidades.Empresa;
import com.autobots.automanager.modelos.EmpresaAtualizador;
import com.autobots.automanager.repositorios.EmpresaRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmpresaServico {
     private EmpresaRepositorio repositorio;
     private EmpresaAtualizador atualizador;

    public Empresa salvar(Empresa empresa) { return repositorio.save(empresa); }
    public List<Empresa> obterTodas() { return repositorio.findAll(); }
    public Empresa obterPorId(Long id) { return repositorio.findById(id).orElse(null); }
    public Empresa atualizar(Empresa atualizacao) {
        Empresa alvo = obterPorId(atualizacao.getId());
        if (alvo != null) {
            atualizador.atualizar(alvo, atualizacao);
            return repositorio.save(alvo);
        }
        return null;
    }
    public void excluir(Long id) { repositorio.deleteById(id); }
}