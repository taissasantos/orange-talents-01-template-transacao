package br.com.zup.transacao.config;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import br.com.zup.transacao.model.Transacao;
import br.com.zup.transacao.repository.CartaoRepository;
import br.com.zup.transacao.repository.TransacaoRepository;
import br.com.zup.transacao.transacao.EventoDeTransacao;

@Component
public class ListenerDeTransacao {

	@Autowired
	TransacaoRepository repository;
	

	private EntityManager manager;

	public ListenerDeTransacao(EntityManager manager) {
		this.manager = manager;
	}


	@KafkaListener(topics = "${kafka.topic.transacoes}")
	@Transactional
	public void ouvir(EventoDeTransacao eventoDeTransacao) {
		Transacao transacao = eventoDeTransacao.toModel();
		repository.save(transacao);
	}

}
