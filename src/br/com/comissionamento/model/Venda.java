package br.com.comissionamento.model;

import java.math.BigDecimal;
import java.util.Calendar;

public class Venda {
	
	private Calendar data;
	private BigDecimal valor;
	
	public Venda(Calendar data, BigDecimal valor) {
		this.data = data;
		this.valor = valor;
	}
	
	public BigDecimal getValor() {
		return this.valor;
	}
	
}
