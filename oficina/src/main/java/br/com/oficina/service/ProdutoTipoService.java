package br.com.oficina.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import br.com.oficina.model.ProdutoTipo;
import br.com.oficina.model.ProdutoTipo;
import br.com.oficina.repository.ProdutoTipoRepository;

@Service
public class ProdutoTipoService  {

	@Autowired
	private  ProdutoTipoRepository repository;
	
	public List<ProdutoTipo> listar() {
		return repository.findAll();
	}

	public ProdutoTipo buscarPeloId(long id) {

		ProdutoTipo ProdutoTipo = repository.findById(id);
		if (ProdutoTipo == null) {
//			throw new RecursoNaoEncontradoException("Nenhum ProdutoTipo foi encontrado");
		}
		return ProdutoTipo;
	}
//
//	public void verificarExistencia(ProdutoTipo ProdutoTipo) {
//		buscarPeloId(ProdutoTipo.getCodigo());
//	}
//
	public ProdutoTipo salvar(ProdutoTipo ProdutoTipo) {
		/*
		 * este metodo nao faz atualizacao por isso e preciso garantir que o id sera
		 * sempre nulo, caso contrario a ProdutoTipo sera atualizado em vez de criado uma nova
		 * ProdutoTipo
		 */

		ProdutoTipo.setCodigo(null);
		return repository.save(ProdutoTipo);
	}
	
	
	public void deletar(long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
//			throw new RecursoNaoEncontradoException("A ProdutoTipo não foi encontrado");
		}
	}



}
