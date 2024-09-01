package br.com.oficina.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import br.com.oficina.model.Pessoa;
import br.com.oficina.model.Pessoa;
import br.com.oficina.repository.PessoaRepository;

@Service
public class PessoaService  {

	@Autowired
	private  PessoaRepository repository;
	

	


}
