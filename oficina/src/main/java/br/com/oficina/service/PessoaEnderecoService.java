package br.com.oficina.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.oficina.repository.PessoaEnderecoRepository;

@Service
public class PessoaEnderecoService{

	@Autowired
	private  PessoaEnderecoRepository repository;

	


}
