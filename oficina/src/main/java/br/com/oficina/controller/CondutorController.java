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

import br.com.oficina.model.Condutor;
import br.com.oficina.service.CondutorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Condutor")
@RestController
@RequestMapping("/api/condutores")
public class CondutorController {

	@Autowired
	private CondutorService condutorService;

	@Operation(summary = "Listar Todos os Condutores")
	@GetMapping("/listarCondutors")
	public List<Condutor> getLista() {
		return condutorService.listar();
	}

	@Operation(summary = "Buscar Condutor Por ID")
	@GetMapping("buscarCondutor/{id}")
	public ResponseEntity<Condutor> buscarPeloId(@PathVariable Long id) {
		Condutor Condutor = condutorService.buscarPeloId(id);
		return ResponseEntity.ok().body(Condutor);
	}

	@Operation(summary = "Inserir Condutor")
	@PostMapping
	public ResponseEntity<Void> salvar(@RequestBody Condutor Condutor) {
		Condutor = condutorService.salvar(Condutor);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(Condutor.getCodigo()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@Operation(summary = "Deletar Condutor")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		condutorService.deletar(id);
		return ResponseEntity.noContent().build();
	}

}
