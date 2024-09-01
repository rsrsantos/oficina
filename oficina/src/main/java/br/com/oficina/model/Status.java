package br.com.oficina.model;

import lombok.Getter;

@Getter
public enum Status {
	
	EMITIDOS("EMITIDOS"), 
	ORCAMENTACAO_RESPONDIDA("ORCAMENTACAO_RESPONDIDA"),
	SERVICOS_PECA_ENTREGUE("SERVICOS_PECA_ENTREGUE"),
	DISPONIVEL_PARA_ORCAMENTO("DISPONIVEL_PARA_ORCAMENTO"),
	AGUARDANDO_ORCAMENTO("AGUARDANDO_ORCAMENTO"),
	AGUARDANDO_ENVIO_VEICULO("AGUARDANDO_ENVIO_VEICULO"),
	AGUARDANDO_COTACAO("AGUARDANDO_COTACAO"),
	CERTAME_ENCERRADO("CERTAME_ENCERRADO"),
	AGUARDANDO_RESPOSTA("AGUARDANDO_RESPOSTA"),
	APROVADA("APROVADA"),
	FINALIZADA("FINALIZADA"),
	NEGADA("NEGADA"),
	SERVICO_REJEITADO("SERVICO_REJEITADO"),
	CANCELADA("CANCELADA");
	
	private String descricao;
	
	private Status(String descricao) {
		this.descricao = descricao;
	}
	
	

}
