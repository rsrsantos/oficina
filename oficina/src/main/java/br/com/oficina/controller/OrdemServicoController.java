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

import br.com.oficina.model.OrdemServico;
import br.com.oficina.service.OrdemServicoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Ordem Servico")
@RestController
@RequestMapping("/api/ordens")
public class OrdemServicoController {

	@Autowired
	private OrdemServicoService ordemServicoService;

	@Operation(summary = "Listar Todas as OrdemServicos")
	@GetMapping("/listarOrdemServicos")
	public List<OrdemServico> getLista() {
		return ordemServicoService.listar();
	}

	@Operation(summary = "Buscar OrdemServico Por ID")
	@GetMapping("buscarOrdemServico/{id}")
	public ResponseEntity<OrdemServico> buscarPeloId(@PathVariable Long id) {
		OrdemServico OrdemServico = ordemServicoService.buscarPeloId(id);
		return ResponseEntity.ok().body(OrdemServico);
	}

	@Operation(summary = "Inserir OrdemServico")
	@PostMapping
	public ResponseEntity<Void> salvar(@RequestBody OrdemServico OrdemServico) {
		OrdemServico = ordemServicoService.salvar(OrdemServico);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(OrdemServico.getCodigo()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@Operation(summary = "Deletar OrdemServico")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		ordemServicoService.deletar(id);
		return ResponseEntity.noContent().build();
	}

}
