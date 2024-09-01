package br.com.oficina.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import br.com.oficina.model.Modelo;
import br.com.oficina.model.Modelo;
import br.com.oficina.repository.ModeloRepository;

@Service
public class ModeloService{

	@Autowired
	private  ModeloRepository repository;
	
	public List<Modelo> listar() {
		return repository.findAll();
	}

	public Modelo buscarPeloId(long id) {

		Modelo Modelo = repository.findById(id);
		if (Modelo == null) {
//			throw new RecursoNaoEncontradoException("Nenhum Modelo foi encontrado");
		}
		return Modelo;
	}
//
//	public void verificarExistencia(Modelo Modelo) {
//		buscarPeloId(Modelo.getCodigo());
//	}
//
	public Modelo salvar(Modelo Modelo) {
		/*
		 * este metodo nao faz atualizacao por isso e preciso garantir que o id sera
		 * sempre nulo, caso contrario a Modelo sera atualizado em vez de criado uma nova
		 * Modelo
		 */

		Modelo.setCodigo(null);
		return repository.save(Modelo);
	}
	
	
	public void deletar(long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
//			throw new RecursoNaoEncontradoException("A Modelo não foi encontrado");
		}
	}

	



}
