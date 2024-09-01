package br.com.oficina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.oficina.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	Produto findById(long id);



}
