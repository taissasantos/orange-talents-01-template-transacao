package br.com.zup.transacao.model;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Estabelecimento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long	id;

	@NotNull
	public String nome;
	@NotNull
	public String cidade;
	@NotNull
	public String endereco;


	public Estabelecimento(){}

	public Estabelecimento(@NotNull String nome, @NotNull String cidade,@NotNull String endereco) {
		super();
		this.nome = nome;
		this.cidade = cidade;
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEndereco() {
		return endereco;
	}

	

}
