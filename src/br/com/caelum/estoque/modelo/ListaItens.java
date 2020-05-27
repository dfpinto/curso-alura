package br.com.caelum.estoque.modelo;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class ListaItens {

	@XmlElement(name = "item")
	private List<Item> itens;

	public ListaItens(List<Item> itens) {
		this.itens = itens;
	}

	ListaItens() {
	}	
}
