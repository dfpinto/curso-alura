package br.com.caelum.estoque.exception;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class InfoFault {

	private String mensagem;
	private Date data;
	
	public InfoFault(String mensagem, Date data) {
		this.mensagem = mensagem;
		this.data = data;
	}
	
	InfoFault(){
	}

}
