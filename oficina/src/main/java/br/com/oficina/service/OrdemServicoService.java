package br.com.oficina.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import br.com.oficina.model.OrdemServico;
import br.com.oficina.model.OrdemServico;
import br.com.oficina.repository.OrdemServicoRepository;

@Service
public class OrdemServicoService {

	@Autowired
	private  OrdemServicoRepository repository;
	
	public List<OrdemServico> listar() {
		return repository.findAll();
	}

	public OrdemServico buscarPeloId(long id) {

		OrdemServico OrdemServico = repository.findById(id);
		if (OrdemServico == null) {
//			throw new RecursoNaoEncontradoException("Nenhum OrdemServico foi encontrado");
		}
		return OrdemServico;
	}
//
//	public void verificarExistencia(OrdemServico OrdemServico) {
//		buscarPeloId(OrdemServico.getCodigo());
//	}
//
	public OrdemServico salvar(OrdemServico OrdemServico) {
		/*
		 * este metodo nao faz atualizacao por isso e preciso garantir que o id sera
		 * sempre nulo, caso contrario a OrdemServico sera atualizado em vez de criado uma nova
		 * OrdemServico
		 */

		OrdemServico.setCodigo(null);
		return repository.save(OrdemServico);
	}
	
	
	public void deletar(long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
//			throw new RecursoNaoEncontradoException("A OrdemServico não foi encontrado");
		}
	}

	
	


}
