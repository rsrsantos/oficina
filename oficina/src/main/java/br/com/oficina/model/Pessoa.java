package br.com.oficina.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter
@Setter
@Table(name="PESSOA")
@Entity

public class Pessoa extends AbstractEntity<Long>{
	
	private String nome;
	private String email;
	private String site;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cod_entidade")
	private Entidade entidade;
	
	
	@Column(name="eh_cliente")
	private Boolean ehCliente;
	
	@Column(name="eh_vendedor")
	private Boolean ehVendedor;
	
	@Column(name="eh_motorista")
	private Boolean ehCondutor;
	
	@Column(name="eh_entidade")
	private Boolean ehEntidade;
	
	@Column(name="eh_oficina")
	private Boolean ehOficina;
	
	@Valid
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="codigo_endereco")
	private PessoaEndereco endereco;
	
	@Valid
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="codigo_contato")
	private PessoaContato contato;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="codigo_fisica")
	private PessoaFisica pessoaFisica;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="codigo_juridica")
	private PessoaJuridica pessoaJuridica;
	
	@Column(columnDefinition = "integer default 0")
	private int statusdelete;

}
