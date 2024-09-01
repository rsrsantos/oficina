package br.com.oficina.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings({ "serial", "unused" })
@Getter
@Setter
@Table(name="pessoa_endereco")
@Entity
public class PessoaEndereco extends AbstractEntity<Long>{
	
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cod_entidade")
	private Entidade entidade;
	
	@NotBlank
	@Column(nullable=false)
	private String logradouro;
	
	@NotBlank
	@Column(nullable=false)
	private String bairro;
	
	@NotBlank
	@Column(nullable=false)
	private String cidade;
	
	@NotNull(message="{NotNull.endereco.uf}")
	@Column(nullable=false, length=2)
	@Enumerated(EnumType.STRING)
	private UF uf;
	
	@NotBlank
	@Size(min = 9,max = 9)
	@Column(nullable=false, length=9)
	private String cep;
	
	@NotNull(message="{NotNull.endereco.numero}")
	@Digits(integer = 5,fraction = 0)
	@Column(nullable=false, length=5)
	private Integer numero;
	
	private String complemento;

}
