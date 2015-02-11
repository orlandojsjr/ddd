package br.com.comissionamento.model.venda;

import java.math.BigDecimal;

import org.joda.time.DateTime;

public class Venda {
	
	private DateTime data;
	private BigDecimal valor;
	
	public Venda(DateTime data, BigDecimal valor) {
		this.data = data;
		this.valor = valor;
	}
	
	public BigDecimal getValor() {
		return this.valor;
	}

	public DateTime getData() {
		return data;
	}
}

