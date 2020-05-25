package br.com.caelum.estoque.ws;

import javax.xml.ws.Endpoint;

public class PublicaWebService {

	public static void main(String[] args) {
		
		EstoqueWS service = new EstoqueWS();
		String url = "http://localhost:8081/estoquews";
		Endpoint.publish(url, service);
		
		// � poss�vel criar/publicar diversos servi�os 
		RelatorioWS servRel = new RelatorioWS();
		String url2 = "http://localhost:8081/relatoriows";
		Endpoint.publish(url2, servRel);
	}
}
