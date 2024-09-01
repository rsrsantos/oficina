package br.com.oficina.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import br.com.oficina.model.Vendedor;
import br.com.oficina.model.Vendedor;
import br.com.oficina.repository.VendedorRepository;

@Service
public class VendedorService  {

	@Autowired
	private VendedorRepository repository;
	
	public List<Vendedor> listar() {
		return repository.findAll();
	}

	public Vendedor buscarPeloId(long id) {

		Vendedor Vendedor = repository.findById(id);
		if (Vendedor == null) {
//			throw new RecursoNaoEncontradoException("Nenhum Vendedor foi encontrado");
		}
		return Vendedor;
	}
//
//	public void verificarExistencia(Vendedor Vendedor) {
//		buscarPeloId(Vendedor.getCodigo());
//	}
//
	public Vendedor salvar(Vendedor Vendedor) {
		/*
		 * este metodo nao faz atualizacao por isso e preciso garantir que o id sera
		 * sempre nulo, caso contrario a Vendedor sera atualizado em vez de criado uma nova
		 * Vendedor
		 */

		Vendedor.setCodigo(null);
		return repository.save(Vendedor);
	}
	
	
	public void deletar(long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
//			throw new RecursoNaoEncontradoException("A Vendedor não foi encontrado");
		}
	}




}
