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

import br.com.oficina.model.Oficina;
import br.com.oficina.service.OficinaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Oficina")
@RestController
@RequestMapping("/api/Oficinas")
public class OficinaController {

	@Autowired
	private OficinaService oficinaService;

	@Operation(summary = "Listar Todas as Oficinas")
	@GetMapping("/listarOficinas")
	public List<Oficina> getLista() {
		return oficinaService.listar();
	}

	@Operation(summary = "Buscar Oficina Por ID")
	@GetMapping("buscarOficina/{id}")
	public ResponseEntity<Oficina> buscarPeloId(@PathVariable Long id) {
		Oficina Oficina = oficinaService.buscarPeloId(id);
		return ResponseEntity.ok().body(Oficina);
	}

	@Operation(summary = "Inserir Oficina")
	@PostMapping
	public ResponseEntity<Void> salvar(@RequestBody Oficina Oficina) {
		Oficina = oficinaService.salvar(Oficina);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(Oficina.getCodigo()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@Operation(summary = "Deletar Oficina")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		oficinaService.deletar(id);
		return ResponseEntity.noContent().build();
	}

}
