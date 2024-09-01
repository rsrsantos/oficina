package br.com.oficina.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import br.com.oficina.model.Servico;
import br.com.oficina.model.Servico;
import br.com.oficina.repository.ServicoRepository;

@Service
public class ServicoService  {

	@Autowired
	private ServicoRepository repository;
	
	public List<Servico> listar() {
		return repository.findAll();
	}

	public Servico buscarPeloId(long id) {

		Servico Servico = repository.findById(id);
		if (Servico == null) {
//			throw new RecursoNaoEncontradoException("Nenhum Servico foi encontrado");
		}
		return Servico;
	}
//
//	public void verificarExistencia(Servico Servico) {
//		buscarPeloId(Servico.getCodigo());
//	}
//
	public Servico salvar(Servico Servico) {
		/*
		 * este metodo nao faz atualizacao por isso e preciso garantir que o id sera
		 * sempre nulo, caso contrario a Servico sera atualizado em vez de criado uma nova
		 * Servico
		 */

		Servico.setCodigo(null);
		return repository.save(Servico);
	}
	
	
	public void deletar(long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
//			throw new RecursoNaoEncontradoException("A Servico não foi encontrado");
		}
	}



}
