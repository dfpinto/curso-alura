package br.com.caelum.estoque.ws;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class RelatorioWS {
	
	@WebMethod(operationName = "gerarRelatorio")
	@Oneway // definie que o método não terá retorno (response) ou output, apenas input, também conhecido como método de mão única.
	public void gerarRelatorio() {
		
	}

}
