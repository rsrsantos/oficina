package br.com.oficina.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import br.com.oficina.model.ServicoCategoria;
import br.com.oficina.model.ServicoCategoria;
import br.com.oficina.repository.ServicoCategoriaRepository;

@Service
public class ServicoCategoriaService  {

	@Autowired
	private  ServicoCategoriaRepository repository;
	
	public List<ServicoCategoria> listar() {
		return repository.findAll();
	}

	public ServicoCategoria buscarPeloId(long id) {

		ServicoCategoria ServicoCategoria = repository.findById(id);
		if (ServicoCategoria == null) {
//			throw new RecursoNaoEncontradoException("Nenhum ServicoCategoria foi encontrado");
		}
		return ServicoCategoria;
	}
//
//	public void verificarExistencia(ServicoCategoria ServicoCategoria) {
//		buscarPeloId(ServicoCategoria.getCodigo());
//	}
//
	public ServicoCategoria salvar(ServicoCategoria ServicoCategoria) {
		/*
		 * este metodo nao faz atualizacao por isso e preciso garantir que o id sera
		 * sempre nulo, caso contrario a ServicoCategoria sera atualizado em vez de criado uma nova
		 * ServicoCategoria
		 */

		ServicoCategoria.setCodigo(null);
		return repository.save(ServicoCategoria);
	}
	
	
	public void deletar(long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
//			throw new RecursoNaoEncontradoException("A ServicoCategoria não foi encontrado");
		}
	}



}
