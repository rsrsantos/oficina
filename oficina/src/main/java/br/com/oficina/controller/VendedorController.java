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

import br.com.oficina.model.Vendedor;
import br.com.oficina.service.VendedorService;
import br.com.oficina.service.VendedorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Vendedor")
@RestController
@RequestMapping("/api/Vendedores")
public class VendedorController {

	@Autowired
	private VendedorService vendedorService;

	@Operation(summary = "Listar Todas as Vendedors")
	@GetMapping("/listarVendedors")
	public List<Vendedor> getLista() {
		return vendedorService.listar();
	}

	@Operation(summary = "Buscar Vendedor Por ID")
	@GetMapping("buscarVendedor/{id}")
	public ResponseEntity<Vendedor> buscarPeloId(@PathVariable Long id) {
		Vendedor Vendedor = vendedorService.buscarPeloId(id);
		return ResponseEntity.ok().body(Vendedor);
	}

	@Operation(summary = "Inserir Vendedor")
	@PostMapping
	public ResponseEntity<Void> salvar(@RequestBody Vendedor Vendedor) {
		Vendedor = vendedorService.salvar(Vendedor);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(Vendedor.getCodigo()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@Operation(summary = "Deletar Vendedor")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		vendedorService.deletar(id);
		return ResponseEntity.noContent().build();
	}

}
