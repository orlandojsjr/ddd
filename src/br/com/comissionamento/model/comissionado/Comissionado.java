package br.com.comissionamento.model.comissionado;

import java.math.BigDecimal;


public class Comissionado {
	
	private BigDecimal porcentagem;
	private ComissionadoTipo tipo;
	
	public Comissionado(BigDecimal porcentagem, ComissionadoTipo tipo) {
		this.porcentagem = porcentagem;
		this.tipo = tipo;
	}

	public BigDecimal getPorcentagem() {
		return porcentagem;
	}

	public ComissionadoTipo getTipo() {
		return tipo;
	}
}

