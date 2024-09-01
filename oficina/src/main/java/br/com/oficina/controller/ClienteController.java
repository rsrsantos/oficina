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

import br.com.oficina.model.Cliente;
import br.com.oficina.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Cliente")
@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@Operation(summary = "Listar Todos os Clientes")
	@GetMapping("/listarClientes")
	public List<Cliente> getLista() {
		return clienteService.listar();
	}

	@Operation(summary = "Buscar Cliente Por ID")
	@GetMapping("buscarCliente/{id}")
	public ResponseEntity<Cliente> buscarPeloId(@PathVariable Long id) {
		Cliente Cliente = clienteService.buscarPeloId(id);
		return ResponseEntity.ok().body(Cliente);
	}

	@Operation(summary = "Inserir Cliente")
	@PostMapping
	public ResponseEntity<Void> salvar(@RequestBody Cliente Cliente) {
		Cliente = clienteService.salvar(Cliente);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(Cliente.getCodigo()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@Operation(summary = "Deletar Cliente")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		clienteService.deletar(id);
		return ResponseEntity.noContent().build();
	}

}
