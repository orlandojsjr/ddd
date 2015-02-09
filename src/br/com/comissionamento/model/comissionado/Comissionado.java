package br.com.comissionamento.model.comissionado;


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

	public ComissionadoTipo getTipo() {
		return tipo;
	}
}

