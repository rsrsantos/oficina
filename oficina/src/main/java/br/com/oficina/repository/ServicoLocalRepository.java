package br.com.oficina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.oficina.model.ServicoLocal;

@Repository
public interface ServicoLocalRepository extends JpaRepository<ServicoLocal, Long> {

	ServicoLocal findById(long id);



}
