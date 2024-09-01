package br.com.oficina.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import br.com.oficina.model.Produto;
import br.com.oficina.model.Produto;
import br.com.oficina.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private  ProdutoRepository repository;
	
	public List<Produto> listar() {
		return repository.findAll();
	}

	public Produto buscarPeloId(long id) {

		Produto Produto = repository.findById(id);
		if (Produto == null) {
//			throw new RecursoNaoEncontradoException("Nenhum Produto foi encontrado");
		}
		return Produto;
	}
//
//	public void verificarExistencia(Produto Produto) {
//		buscarPeloId(Produto.getCodigo());
//	}
//
	public Produto salvar(Produto Produto) {
		/*
		 * este metodo nao faz atualizacao por isso e preciso garantir que o id sera
		 * sempre nulo, caso contrario a Produto sera atualizado em vez de criado uma nova
		 * Produto
		 */

		Produto.setCodigo(null);
		return repository.save(Produto);
	}
	
	
	public void deletar(long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
//			throw new RecursoNaoEncontradoException("A Produto não foi encontrado");
		}
	}

	


}
