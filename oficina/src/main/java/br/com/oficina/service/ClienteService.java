package br.com.oficina.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.oficina.model.Cliente;
import br.com.oficina.repository.ClienteRepository;


@Service
public class ClienteService{

	@Autowired
	private  ClienteRepository repository;
	
	public List<Cliente> listar() {
		return repository.findAll();
	}

	public Cliente buscarPeloId(long id) {

		Cliente Cliente = repository.findById(id);
		if (Cliente == null) {
//			throw new RecursoNaoEncontradoException("Nenhum Cliente foi encontrado");
		}
		return Cliente;
	}
//
//	public void verificarExistencia(Cliente Cliente) {
//		buscarPeloId(Cliente.getCodigo());
//	}
//
	public Cliente salvar(Cliente Cliente) {
		/*
		 * este metodo nao faz atualizacao por isso e preciso garantir que o id sera
		 * sempre nulo, caso contrario a Cliente sera atualizado em vez de criado uma nova
		 * Cliente
		 */

		Cliente.setCodigo(null);
		return repository.save(Cliente);
	}
	
	
	public void deletar(long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
//			throw new RecursoNaoEncontradoException("A Cliente não foi encontrado");
		}
	}

	 



}
