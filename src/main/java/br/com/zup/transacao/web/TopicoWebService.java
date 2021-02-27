package br.com.zup.transacao.web;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.zup.transacao.request.DadosTransacaoRequest;
import br.com.zup.transacao.web.response.TransacaoResponse;

@FeignClient(url = "http://localhost:7777", name = "topicos")
public interface TopicoWebService {

	@PostMapping("/api/cartoes")
	TransacaoResponse enviaDadosTransacao(DadosTransacaoRequest request);
}
