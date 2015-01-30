package br.com.comissionamento.model;

public class Comissionado {
	
	private Double porcentagem;
	private ComissionadoTipo tipo;
	
	public Comissionado(Double porcentagem, ComissionadoTipo tipo) {
		this.porcentagem = porcentagem;
		this.tipo = tipo;
	}

	public Double getPorcentagem() {
		return porcentagem;
	}
}
