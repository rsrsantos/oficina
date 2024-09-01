package br.com.oficina.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.oficina.model.Oficina;
import br.com.oficina.repository.OficinaRepository;
import br.com.oficina.repository.OrcamentoRepository;


@Service
public class OficinaService {

	@Autowired
	private  OficinaRepository repository;
	
	public List<Oficina> listar() {
		return repository.findAll();
	}

	public Oficina buscarPeloId(long id) {

		Oficina Oficina = repository.findById(id);
		if (Oficina == null) {
//			throw new RecursoNaoEncontradoException("Nenhum Oficina foi encontrado");
		}
		return Oficina;
	}
//
//	public void verificarExistencia(Oficina Oficina) {
//		buscarPeloId(Oficina.getCodigo());
//	}
//
	public Oficina salvar(Oficina Oficina) {
		/*
		 * este metodo nao faz atualizacao por isso e preciso garantir que o id sera
		 * sempre nulo, caso contrario a Oficina sera atualizado em vez de criado uma nova
		 * Oficina
		 */

		Oficina.setCodigo(null);
		return repository.save(Oficina);
	}
	
	
	public void deletar(long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
//			throw new RecursoNaoEncontradoException("A Oficina não foi encontrado");
		}
	}



}
