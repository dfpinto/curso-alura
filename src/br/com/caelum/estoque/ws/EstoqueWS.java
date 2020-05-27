package br.com.caelum.estoque.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import br.com.caelum.estoque.exception.AuthorizationException;
import br.com.caelum.estoque.modelo.Filtro;
import br.com.caelum.estoque.modelo.Filtros;
import br.com.caelum.estoque.modelo.Item;
import br.com.caelum.estoque.modelo.ItemDao;
import br.com.caelum.estoque.modelo.ListaItens;
import br.com.caelum.estoque.modelo.usuario.TokenDao;
import br.com.caelum.estoque.modelo.usuario.TokenUsuario;

@WebService
// O padrão é DOCUMENT, LITERAL e WRAPPER.
@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL, parameterStyle = ParameterStyle.WRAPPED)
public class EstoqueWS {

	private ItemDao dao = new ItemDao();

	@WebMethod(operationName = "todosOsItens") // dá nome a operação no wsdl
	@WebResult(name = "item") // dá nome ao nó de resposta do wsdl enviado pelo servidor (response)
	@ResponseWrapper(localName = "itens")
	@RequestWrapper(localName = "listaItens")
	public List<Item> getItens(@WebParam(name = "filtros") Filtros filtros) {
		System.out.println("Chamando getItens()");
		List<Filtro> lista = filtros.getLista();
		List<Item> itensResultado = dao.todosItens(lista);
		return itensResultado;
	}

	@WebMethod(operationName = "cadastrarItem")
	@WebResult(name = "itens")
	public Item cadastrarItem(@WebParam(name = "tokenUsuario", header = true) TokenUsuario token,
			@WebParam(name = "item") Item item) throws AuthorizationException {

		System.out.println("Cadastrando " + item + ", " + token);

		boolean valido = new TokenDao().ehValido(token);

		if (!valido) {
			throw new AuthorizationException("Token invalido");
		}

		this.dao.cadastrar(item);
		return item;
	}
}