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

import br.com.oficina.model.Veiculo;
import br.com.oficina.service.VeiculoService;
import br.com.oficina.service.VeiculoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Veiculo")
@RestController
@RequestMapping("/api/Veiculos")
public class VeiculoController {

	@Autowired
	private VeiculoService veiculoService;

	@Operation(summary = "Listar Todas as Veiculos")
	@GetMapping("/listarVeiculos")
	public List<Veiculo> getLista() {
		return veiculoService.listar();
	}

	@Operation(summary = "Buscar Veiculo Por ID")
	@GetMapping("buscarVeiculo/{id}")
	public ResponseEntity<Veiculo> buscarPeloId(@PathVariable Long id) {
		Veiculo Veiculo = veiculoService.buscarPeloId(id);
		return ResponseEntity.ok().body(Veiculo);
	}

	@Operation(summary = "Inserir Veiculo")
	@PostMapping
	public ResponseEntity<Void> salvar(@RequestBody Veiculo Veiculo) {
		Veiculo = veiculoService.salvar(Veiculo);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(Veiculo.getCodigo()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@Operation(summary = "Deletar Veiculo")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		veiculoService.deletar(id);
		return ResponseEntity.noContent().build();
	}

}
