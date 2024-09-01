package br.com.oficina.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.oficina.model.Orcamento;
import br.com.oficina.repository.OrcamentoRepository;


@Service
public class OrcamentoService {

	@Autowired
	private  OrcamentoRepository repository;
	
	public List<Orcamento> listar() {
		return repository.findAll();
	}

	public Orcamento buscarPeloId(long id) {

		Orcamento Orcamento = repository.findById(id);
		if (Orcamento == null) {
//			throw new RecursoNaoEncontradoException("Nenhum Orcamento foi encontrado");
		}
		return Orcamento;
	}
//
//	public void verificarExistencia(Orcamento Orcamento) {
//		buscarPeloId(Orcamento.getCodigo());
//	}
//
	public Orcamento salvar(Orcamento Orcamento) {
		/*
		 * este metodo nao faz atualizacao por isso e preciso garantir que o id sera
		 * sempre nulo, caso contrario a Orcamento sera atualizado em vez de criado uma nova
		 * Orcamento
		 */

		Orcamento.setCodigo(null);
		return repository.save(Orcamento);
	}
	
	
	public void deletar(long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
//			throw new RecursoNaoEncontradoException("A Orcamento não foi encontrado");
		}
	}



}
