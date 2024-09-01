package br.com.oficina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.oficina.model.ServicoCategoria;

@Repository
public interface ServicoCategoriaRepository extends JpaRepository<ServicoCategoria, Long> {

	ServicoCategoria findById(long id);



}
