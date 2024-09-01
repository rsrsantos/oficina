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

import br.com.oficina.model.ProdutoTipo;
import br.com.oficina.service.ProdutoTipoService;
import br.com.oficina.service.ProdutoTipoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "ProdutoTipo")
@RestController
@RequestMapping("/api/ProdutoTipos")
public class ProdutoTipoController {

	@Autowired
	private ProdutoTipoService produtoTipoService;

	@Operation(summary = "Listar Todas as Produto Tipos")
	@GetMapping("/listarProdutoTipos")
	public List<ProdutoTipo> getLista() {
		return produtoTipoService.listar();
	}

	@Operation(summary = "Buscar Produto Tipo Por ID")
	@GetMapping("buscarProdutoTipo/{id}")
	public ResponseEntity<ProdutoTipo> buscarPeloId(@PathVariable Long id) {
		ProdutoTipo ProdutoTipo = produtoTipoService.buscarPeloId(id);
		return ResponseEntity.ok().body(ProdutoTipo);
	}

	@Operation(summary = "Inserir Produto Tipo")
	@PostMapping
	public ResponseEntity<Void> salvar(@RequestBody ProdutoTipo ProdutoTipo) {
		ProdutoTipo = produtoTipoService.salvar(ProdutoTipo);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(ProdutoTipo.getCodigo()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@Operation(summary = "Deletar Produto Tipo")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		produtoTipoService.deletar(id);
		return ResponseEntity.noContent().build();
	}

}
