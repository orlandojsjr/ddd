package br.com.comissionamento.model.venda;

import org.joda.time.DateTime;

public class Venda {
	
	private DateTime data;
	private Double valor;
	
	public Venda(DateTime data, Double valor) {
		this.data = data;
		this.valor = valor;
	}
	
	public Double getValor() {
		return this.valor;
	}

	public DateTime getData() {
		return data;
	}
}

