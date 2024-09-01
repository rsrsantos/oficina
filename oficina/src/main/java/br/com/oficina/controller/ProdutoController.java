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

import br.com.oficina.model.Produto;
import br.com.oficina.service.ProdutoService;
import br.com.oficina.service.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Produto")
@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@Operation(summary = "Listar Todas as Produtos")
	@GetMapping("/listarProdutos")
	public List<Produto> getLista() {
		return produtoService.listar();
	}

	@Operation(summary = "Buscar Produto Por ID")
	@GetMapping("buscarProduto/{id}")
	public ResponseEntity<Produto> buscarPeloId(@PathVariable Long id) {
		Produto Produto = produtoService.buscarPeloId(id);
		return ResponseEntity.ok().body(Produto);
	}

	@Operation(summary = "Inserir Produto")
	@PostMapping
	public ResponseEntity<Void> salvar(@RequestBody Produto Produto) {
		Produto = produtoService.salvar(Produto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(Produto.getCodigo()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@Operation(summary = "Deletar Produto")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		produtoService.deletar(id);
		return ResponseEntity.noContent().build();
	}

}
