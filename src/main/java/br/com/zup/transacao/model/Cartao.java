package br.com.zup.transacao.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
public class Cartao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long	id;
	
	@NotNull
	private String numero;
	
	@Email
	public String email;
	
	public Cartao(){}

	public Cartao(@NotNull String numero, @Email String email) {
		super();
		this.numero = numero;
		this.email = email;
	}

	public String getNumero() {
		return numero;
	}


	public String getEmail() {
		return email;
	}

	

}
