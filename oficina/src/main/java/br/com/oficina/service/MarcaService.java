package br.com.oficina.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.oficina.repository.MarcaRepository;
import br.com.oficina.model.Marca;

@Service
public class MarcaService {

	@Autowired
	private MarcaRepository repository;

	public List<Marca> listar() {
		return repository.findAll();
	}

	public Marca buscarPeloId(long id) {

		Marca marca = repository.findById(id);
		if (marca == null) {
//			throw new RecursoNaoEncontradoException("Nenhum marca foi encontrado");
		}
		return marca;
	}
//
//	public void verificarExistencia(Marca marca) {
//		buscarPeloId(marca.getCodigo());
//	}
//
	public Marca salvar(Marca marca) {
		/*
		 * este metodo nao faz atualizacao por isso e preciso garantir que o id sera
		 * sempre nulo, caso contrario a marca sera atualizado em vez de criado uma nova
		 * marca
		 */

		marca.setCodigo(null);
		return repository.save(marca);
	}
	
	
	public void deletar(long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
//			throw new RecursoNaoEncontradoException("A marca não foi encontrado");
		}
	}

}
