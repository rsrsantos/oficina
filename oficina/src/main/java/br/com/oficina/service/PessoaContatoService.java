package br.com.oficina.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import br.com.oficina.model.PessoaContato;
import br.com.oficina.repository.PessoaContatoRepository;

@Service
public class PessoaContatoService {

	@Autowired
	private  PessoaContatoRepository repository;



}
