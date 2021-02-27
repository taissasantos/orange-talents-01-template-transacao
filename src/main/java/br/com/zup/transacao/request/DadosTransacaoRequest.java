package br.com.zup.transacao.request;

import br.com.zup.transacao.model.Transacao;

public class DadosTransacaoRequest {

	private String id;
	private String email;
	
	public DadosTransacaoRequest(Transacao transacao) {
		super();
		this.id = transacao.getId().toString();
		this.email = transacao.getCartao().getEmail();
	}

	public String getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}
	
	
	
}
