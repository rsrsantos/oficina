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

import br.com.oficina.model.ProdutoCategoria;
import br.com.oficina.service.ProdutoCategoriaService;
import br.com.oficina.service.ProdutoCategoriaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Produto Categoria")
@RestController
@RequestMapping("/api/ProdutoCategorias")
public class ProdutoCategoriaController {

	@Autowired
	private ProdutoCategoriaService produtoCategoriaService;

	@Operation(summary = "Listar Todas as Produto Categorias")
	@GetMapping("/listarProdutoCategorias")
	public List<ProdutoCategoria> getLista() {
		return produtoCategoriaService.listar();
	}

	@Operation(summary = "Buscar Produto Categoria Por ID")
	@GetMapping("buscarProdutoCategoria/{id}")
	public ResponseEntity<ProdutoCategoria> buscarPeloId(@PathVariable Long id) {
		ProdutoCategoria ProdutoCategoria = produtoCategoriaService.buscarPeloId(id);
		return ResponseEntity.ok().body(ProdutoCategoria);
	}

	@Operation(summary = "Inserir Produto Categoria")
	@PostMapping
	public ResponseEntity<Void> salvar(@RequestBody ProdutoCategoria ProdutoCategoria) {
		ProdutoCategoria = produtoCategoriaService.salvar(ProdutoCategoria);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(ProdutoCategoria.getCodigo()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@Operation(summary = "Deletar Produto Categoria")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		produtoCategoriaService.deletar(id);
		return ResponseEntity.noContent().build();
	}

}
