package br.com.oficina.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.oficina.model.Orcamento;
import br.com.oficina.service.OrcamentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Orcamento")
@RestController
@RequestMapping("/api/orcamentos")
public class OrcamentoController {

	@Autowired
	private OrcamentoService orcamentoService;

	@Operation(summary = "Listar Todas as Orcamentos")
	@GetMapping("/listarOrcamentos")
	public List<Orcamento> getLista() {
		return orcamentoService.listar();
	}

	@Operation(summary = "Buscar Orcamento Por ID")
	@GetMapping("buscarOrcamento/{id}")
	public ResponseEntity<Orcamento> buscarPeloId(@PathVariable Long id) {
		Orcamento Orcamento = orcamentoService.buscarPeloId(id);
		return ResponseEntity.ok().body(Orcamento);
	}

	@Operation(summary = "Inserir Orcamento")
	@PostMapping
	public ResponseEntity<Void> salvar(@RequestBody Orcamento Orcamento) {
		Orcamento = orcamentoService.salvar(Orcamento);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(Orcamento.getCodigo()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@Operation(summary = "Deletar Orcamento")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		orcamentoService.deletar(id);
		return ResponseEntity.noContent().build();
	}

}
