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

import br.com.oficina.model.Servico;
import br.com.oficina.service.ServicoService;
import br.com.oficina.service.ServicoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Servico")
@RestController
@RequestMapping("/api/Servicos")
public class ServicoController {

	@Autowired
	private ServicoService servicoService;

	@Operation(summary = "Listar Todas as Servicos")
	@GetMapping("/listarServicos")
	public List<Servico> getLista() {
		return servicoService.listar();
	}

	@Operation(summary = "Buscar Servico Por ID")
	@GetMapping("buscarServico/{id}")
	public ResponseEntity<Servico> buscarPeloId(@PathVariable Long id) {
		Servico Servico = servicoService.buscarPeloId(id);
		return ResponseEntity.ok().body(Servico);
	}

	@Operation(summary = "Inserir Servico")
	@PostMapping
	public ResponseEntity<Void> salvar(@RequestBody Servico Servico) {
		Servico = servicoService.salvar(Servico);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(Servico.getCodigo()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@Operation(summary = "Deletar Servico")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		servicoService.deletar(id);
		return ResponseEntity.noContent().build();
	}

}
