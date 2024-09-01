package br.com.oficina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.oficina.model.Oficina;

@Repository
public interface OficinaRepository extends JpaRepository<Oficina, Long> {

	Oficina findById(long id);



}
