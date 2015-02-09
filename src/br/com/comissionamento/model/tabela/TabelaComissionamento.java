package br.com.comissionamento.model.tabela;

import java.util.List;

import br.com.comissionamento.model.comissionado.Comissionado;

public class TabelaComissionamento {
	
	private List<Comissionado> comissionados;
	
	public TabelaComissionamento(List<Comissionado> comissionados) {
		this.comissionados = comissionados;
	}

	public List<Comissionado> getComissionados() {
		return comissionados;
	}	
}

