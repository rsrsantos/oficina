package br.com.oficina.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import br.com.oficina.model.ServicoLocal;
import br.com.oficina.model.ServicoLocal;
import br.com.oficina.repository.ServicoLocalRepository;

@Service
public class ServicoLocalService {

	@Autowired
	private  ServicoLocalRepository repository;
	
	public List<ServicoLocal> listar() {
		return repository.findAll();
	}

	public ServicoLocal buscarPeloId(long id) {

		ServicoLocal ServicoLocal = repository.findById(id);
		if (ServicoLocal == null) {
//			throw new RecursoNaoEncontradoException("Nenhum ServicoLocal foi encontrado");
		}
		return ServicoLocal;
	}
//
//	public void verificarExistencia(ServicoLocal ServicoLocal) {
//		buscarPeloId(ServicoLocal.getCodigo());
//	}
//
	public ServicoLocal salvar(ServicoLocal ServicoLocal) {
		/*
		 * este metodo nao faz atualizacao por isso e preciso garantir que o id sera
		 * sempre nulo, caso contrario a ServicoLocal sera atualizado em vez de criado uma nova
		 * ServicoLocal
		 */

		ServicoLocal.setCodigo(null);
		return repository.save(ServicoLocal);
	}
	
	
	public void deletar(long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
//			throw new RecursoNaoEncontradoException("A ServicoLocal não foi encontrado");
		}
	}



}
