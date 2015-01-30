package br.com.comissionamento.model;

import java.util.List;

import org.joda.time.DateTime;

public class TabelaComissionamento {
	
	private DateTime dataCalculo;
	private List<Comissionado> comissionados;
	
	public TabelaComissionamento(DateTime dataCalculo, List<Comissionado> comissionados) {
		this.dataCalculo = dataCalculo;
		this.comissionados = comissionados;
	}

	public DateTime getDataCalculo() {
		return dataCalculo;
	}

	public List<Comissionado> getComissionados() {
		return comissionados;
	}	
}
