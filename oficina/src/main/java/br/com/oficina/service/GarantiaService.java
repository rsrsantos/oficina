package br.com.oficina.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.oficina.model.Garantia;
import br.com.oficina.repository.GarantiaRepository;

@Service
public class GarantiaService {

	@Autowired
	private  GarantiaRepository repository;
	
	public List<Garantia> listar() {
		return repository.findAll();
	}

	public Garantia buscarPeloId(long id) {

		Garantia Garantia = repository.findById(id);
		if (Garantia == null) {
//			throw new RecursoNaoEncontradoException("Nenhum Garantia foi encontrado");
		}
		return Garantia;
	}
//
//	public void verificarExistencia(Garantia Garantia) {
//		buscarPeloId(Garantia.getCodigo());
//	}
//
	public Garantia salvar(Garantia Garantia) {
		/*
		 * este metodo nao faz atualizacao por isso e preciso garantir que o id sera
		 * sempre nulo, caso contrario a Garantia sera atualizado em vez de criado uma nova
		 * Garantia
		 */

		Garantia.setCodigo(null);
		return repository.save(Garantia);
	}
	
	
	public void deletar(long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
//			throw new RecursoNaoEncontradoException("A Garantia não foi encontrado");
		}
	}




}
