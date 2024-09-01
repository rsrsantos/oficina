package br.com.oficina.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.oficina.model.Entidade;
import br.com.oficina.repository.EntidadeRepository;
import br.com.oficina.repository.EntidadeRepository;


@Service
public class EntidadeService{

	@Autowired
	private  EntidadeRepository repository;
	
	public List<Entidade> listar() {
		return repository.findAll();
	}

	public Entidade buscarPeloId(long id) {

		Entidade Entidade = repository.findById(id);
		if (Entidade == null) {
//			throw new RecursoNaoEncontradoException("Nenhum Entidade foi encontrado");
		}
		return Entidade;
	}
//
//	public void verificarExistencia(Entidade Entidade) {
//		buscarPeloId(Entidade.getCodigo());
//	}
//
	public Entidade salvar(Entidade Entidade) {
		/*
		 * este metodo nao faz atualizacao por isso e preciso garantir que o id sera
		 * sempre nulo, caso contrario a Entidade sera atualizado em vez de criado uma nova
		 * Entidade
		 */

		Entidade.setCodigo(null);
		return repository.save(Entidade);
	}
	
	
	public void deletar(long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
//			throw new RecursoNaoEncontradoException("A Entidade não foi encontrado");
		}
	}

	 



}
