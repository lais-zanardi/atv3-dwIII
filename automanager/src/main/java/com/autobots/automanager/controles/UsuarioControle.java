package com.autobots.automanager.controles;

import com.autobots.automanager.entidades.Usuario;
import com.autobots.automanager.modelos.AdicionadorLinkUsuario;
import com.autobots.automanager.servicos.UsuarioServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioControle {
	@Autowired
	private UsuarioServico servico;
	@Autowired private AdicionadorLinkUsuario adicionadorLink;

	@PostMapping("/cadastrar")
	public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario) {
		Usuario salvo = servico.salvar(usuario);
		adicionadorLink.adicionarLink(salvo);
		return new ResponseEntity<>(salvo, HttpStatus.CREATED);
	}

	@GetMapping("/obter")
	public ResponseEntity<List<Usuario>> obterUsuarios() {
		List<Usuario> usuarios = servico.obterTodos();
		adicionadorLink.adicionarLink(usuarios);
		return new ResponseEntity<>(usuarios, HttpStatus.FOUND);
	}

	@GetMapping("/obter/{id}")
	public ResponseEntity<Usuario> obterUsuario(@PathVariable Long id) {
		Usuario usuario = servico.obterPorId(id);
		if (usuario == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		adicionadorLink.adicionarLink(usuario);
		return new ResponseEntity<>(usuario, HttpStatus.FOUND);
	}

	@PutMapping("/atualizar")
	public ResponseEntity<Usuario> atualizarUsuario(@RequestBody Usuario usuario) {
		Usuario atualizado = servico.atualizar(usuario);
		if (atualizado == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		adicionadorLink.adicionarLink(atualizado);
		return new ResponseEntity<>(atualizado, HttpStatus.OK);
	}

	@DeleteMapping("/excluir/{id}")
	public ResponseEntity<?> excluirUsuario(@PathVariable Long id) {
		if (servico.obterPorId(id) == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		servico.excluir(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}