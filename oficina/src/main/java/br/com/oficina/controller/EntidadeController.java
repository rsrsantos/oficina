package br.com.oficina.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.oficina.model.Entidade;
import br.com.oficina.service.EntidadeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Entidade")
@RestController
@RequestMapping("/api/entidades")
public class EntidadeController {

	@Autowired
	private EntidadeService entidadeService;

	@Operation(summary = "Listar Todas as Entidades")
	@GetMapping("/listarEntidades")
	public List<Entidade> getLista() {
		return entidadeService.listar();
	}

	@Operation(summary = "Buscar Entidade Por ID")
	@GetMapping("buscarEntidade/{id}")
	public ResponseEntity<Entidade> buscarPeloId(@PathVariable Long id) {
		Entidade Entidade = entidadeService.buscarPeloId(id);
		return ResponseEntity.ok().body(Entidade);
	}

	@Operation(summary = "Inserir Entidade")
	@PostMapping
	public ResponseEntity<Void> salvar(@RequestBody Entidade Entidade) {
		Entidade = entidadeService.salvar(Entidade);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(Entidade.getCodigo()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@Operation(summary = "Deletar Entidade")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		entidadeService.deletar(id);
		return ResponseEntity.noContent().build();
	}

}
