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

import br.com.oficina.model.Marca;
import br.com.oficina.service.MarcaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Marca")
@RestController
@RequestMapping("/api/marcas")
public class MarcaController {

	@Autowired
	private MarcaService marcaService;

	@Operation(summary = "Listar Todas as Marcas")
	@GetMapping("/listarMarcas")
	public List<Marca> getLista() {
		return marcaService.listar();
	}

	@Operation(summary = "Buscar Marca Por ID")
	@GetMapping("buscarMarca/{id}")
	public ResponseEntity<Marca> buscarPeloId(@PathVariable Long id) {
		Marca marca = marcaService.buscarPeloId(id);
		return ResponseEntity.ok().body(marca);
	}

	@Operation(summary = "Inserir Marca")
	@PostMapping
	public ResponseEntity<Void> salvar(@RequestBody Marca marca) {
		marca = marcaService.salvar(marca);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(marca.getCodigo()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@Operation(summary = "Deletar Marca")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		marcaService.deletar(id);
		return ResponseEntity.noContent().build();
	}

}
