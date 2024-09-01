package br.com.oficina.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import br.com.oficina.model.ProdutoCategoria;
import br.com.oficina.model.ProdutoCategoria;
import br.com.oficina.repository.ProdutoCategoriaRepository;

@Service
public class ProdutoCategoriaService  {

	@Autowired
	private  ProdutoCategoriaRepository repository;
	
	public List<ProdutoCategoria> listar() {
		return repository.findAll();
	}

	public ProdutoCategoria buscarPeloId(long id) {

		ProdutoCategoria ProdutoCategoria = repository.findById(id);
		if (ProdutoCategoria == null) {
//			throw new RecursoNaoEncontradoException("Nenhum ProdutoCategoria foi encontrado");
		}
		return ProdutoCategoria;
	}
//
//	public void verificarExistencia(ProdutoCategoria ProdutoCategoria) {
//		buscarPeloId(ProdutoCategoria.getCodigo());
//	}
//
	public ProdutoCategoria salvar(ProdutoCategoria ProdutoCategoria) {
		/*
		 * este metodo nao faz atualizacao por isso e preciso garantir que o id sera
		 * sempre nulo, caso contrario a ProdutoCategoria sera atualizado em vez de criado uma nova
		 * ProdutoCategoria
		 */

		ProdutoCategoria.setCodigo(null);
		return repository.save(ProdutoCategoria);
	}
	
	
	public void deletar(long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
//			throw new RecursoNaoEncontradoException("A ProdutoCategoria não foi encontrado");
		}
	}



}
