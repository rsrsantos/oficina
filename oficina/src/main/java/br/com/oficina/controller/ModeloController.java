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

import br.com.oficina.model.Modelo;
import br.com.oficina.service.ModeloService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Modelo")
@RestController
@RequestMapping("/api/modelos")
public class ModeloController {

	@Autowired
	private ModeloService modeloService;

	@Operation(summary = "Listar Todas as Modelos")
	@GetMapping("/listarModelos")
	public List<Modelo> getLista() {
		return modeloService.listar();
	}

	@Operation(summary = "Buscar Modelo Por ID")
	@GetMapping("buscarModelo/{id}")
	public ResponseEntity<Modelo> buscarPeloId(@PathVariable Long id) {
		Modelo Modelo = modeloService.buscarPeloId(id);
		return ResponseEntity.ok().body(Modelo);
	}

	@Operation(summary = "Inserir Modelo")
	@PostMapping
	public ResponseEntity<Void> salvar(@RequestBody Modelo Modelo) {
		Modelo = modeloService.salvar(Modelo);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(Modelo.getCodigo()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@Operation(summary = "Deletar Modelo")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		modeloService.deletar(id);
		return ResponseEntity.noContent().build();
	}

}
