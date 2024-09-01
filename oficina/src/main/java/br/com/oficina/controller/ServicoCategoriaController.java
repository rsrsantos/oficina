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

import br.com.oficina.model.ServicoCategoria;
import br.com.oficina.service.ServicoCategoriaService;
import br.com.oficina.service.ServicoCategoriaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Servico Categoria")
@RestController
@RequestMapping("/api/ServicoCategorias")
public class ServicoCategoriaController {

	@Autowired
	private ServicoCategoriaService servicoCategoriaService;

	@Operation(summary = "Listar Todas as ServicoCategorias")
	@GetMapping("/listarServicoCategorias")
	public List<ServicoCategoria> getLista() {
		return servicoCategoriaService.listar();
	}

	@Operation(summary = "Buscar ServicoCategoria Por ID")
	@GetMapping("buscarServicoCategoria/{id}")
	public ResponseEntity<ServicoCategoria> buscarPeloId(@PathVariable Long id) {
		ServicoCategoria ServicoCategoria = servicoCategoriaService.buscarPeloId(id);
		return ResponseEntity.ok().body(ServicoCategoria);
	}

	@Operation(summary = "Inserir ServicoCategoria")
	@PostMapping
	public ResponseEntity<Void> salvar(@RequestBody ServicoCategoria ServicoCategoria) {
		ServicoCategoria = servicoCategoriaService.salvar(ServicoCategoria);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(ServicoCategoria.getCodigo()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@Operation(summary = "Deletar Servico Categoria")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		servicoCategoriaService.deletar(id);
		return ResponseEntity.noContent().build();
	}

}
