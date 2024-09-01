package br.com.oficina.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter
@Setter
@Table(name="veiculo")
@Entity

public class Veiculo extends AbstractEntity<Long>{
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cod_entidade")
	private Entidade entidade;
	
	private String placa;
	private String motorizacao;
	private String ano;
	private String tipo;
	private String chassi;
	private String cor;
	private String transmissao;
	private String combustivel;
	private String capacidade_tanque;
	private String cidade;
	
	@Valid
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="marca")
	private Marca marca;
	
	@Valid
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="modelo")
	private Modelo modelo;
	
	@Column(columnDefinition = "integer default 0")
	private int statusdelete;

}
