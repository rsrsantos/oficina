package br.com.oficina.model;


import java.io.Serializable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@EqualsAndHashCode
@SuppressWarnings("serial")
@MappedSuperclass
public abstract class AbstractEntity<ID extends Serializable>implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private ID codigo;

}
