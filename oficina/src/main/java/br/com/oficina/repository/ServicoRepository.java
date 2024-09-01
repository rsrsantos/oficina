package br.com.oficina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.oficina.model.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {

	Servico findById(long id);



}
