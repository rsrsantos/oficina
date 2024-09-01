package br.com.oficina.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.oficina.model.Condutor;
import br.com.oficina.repository.CondutorRepository;
import br.com.oficina.repository.CondutorRepository;


@Service
public class CondutorService{

	@Autowired
	private  CondutorRepository repository;
	
	public List<Condutor> listar() {
		return repository.findAll();
	}

	public Condutor buscarPeloId(long id) {

		Condutor Condutor = repository.findById(id);
		if (Condutor == null) {
//			throw new RecursoNaoEncontradoException("Nenhum Condutor foi encontrado");
		}
		return Condutor;
	}
//
//	public void verificarExistencia(Condutor Condutor) {
//		buscarPeloId(Condutor.getCodigo());
//	}
//
	public Condutor salvar(Condutor Condutor) {
		/*
		 * este metodo nao faz atualizacao por isso e preciso garantir que o id sera
		 * sempre nulo, caso contrario a Condutor sera atualizado em vez de criado uma nova
		 * Condutor
		 */

		Condutor.setCodigo(null);
		return repository.save(Condutor);
	}
	
	
	public void deletar(long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
//			throw new RecursoNaoEncontradoException("A Condutor não foi encontrado");
		}
	}

	 



}
