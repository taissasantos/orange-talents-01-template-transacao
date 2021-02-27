package br.com.zup.transacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.transacao.model.Transacao;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
	
	

}
