package br.com.oficina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.oficina.model.Vendedor;

@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, Long> {

	Vendedor findById(long id);



}
