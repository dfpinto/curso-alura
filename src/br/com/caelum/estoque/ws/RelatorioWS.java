package br.com.caelum.estoque.ws;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class RelatorioWS {
	
	@WebMethod(operationName = "gerarRelatorio")
	@Oneway // definie que o m�todo n�o ter� retorno (response) ou output, apenas input, tamb�m conhecido como m�todo de m�o �nica.
	public void gerarRelatorio() {
		
	}

}
