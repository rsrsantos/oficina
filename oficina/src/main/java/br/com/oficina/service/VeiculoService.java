package br.com.oficina.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import br.com.oficina.model.Veiculo;
import br.com.oficina.model.Veiculo;
import br.com.oficina.repository.VeiculoRepository;

@Service
public class VeiculoService {

	@Autowired
	private VeiculoRepository repository;
	
	public List<Veiculo> listar() {
		return repository.findAll();
	}

	public Veiculo buscarPeloId(long id) {

		Veiculo Veiculo = repository.findById(id);
		if (Veiculo == null) {
//			throw new RecursoNaoEncontradoException("Nenhum Veiculo foi encontrado");
		}
		return Veiculo;
	}
//
//	public void verificarExistencia(Veiculo Veiculo) {
//		buscarPeloId(Veiculo.getCodigo());
//	}
//
	public Veiculo salvar(Veiculo Veiculo) {
		/*
		 * este metodo nao faz atualizacao por isso e preciso garantir que o id sera
		 * sempre nulo, caso contrario a Veiculo sera atualizado em vez de criado uma nova
		 * Veiculo
		 */

		Veiculo.setCodigo(null);
		return repository.save(Veiculo);
	}
	
	
	public void deletar(long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
//			throw new RecursoNaoEncontradoException("A Veiculo não foi encontrado");
		}
	}



}
