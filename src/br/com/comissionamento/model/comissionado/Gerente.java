package br.com.comissionamento.model.comissionado;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

import br.com.comissionamento.model.tabela.TabelaComissionamento;
import br.com.comissionamento.model.tabela.PeriodoVigencia;

public class Gerente implements Comissionado {
	private List<TabelaComissionamento> tabelas;
	
	{
		 tabelas =  new ArrayList<TabelaComissionamento>() {{
			 add(new TabelaComissionamento(new BigDecimal("0.03"), new PeriodoVigencia(new DateTime(2014, 01, 31, 0, 0), new DateTime(2014, 12, 31, 0, 0)))); 
			 add(new TabelaComissionamento(new BigDecimal("0.03"), new PeriodoVigencia(new DateTime(2015, 01, 01, 0, 0), new DateTime(2015, 12, 31, 0, 0))));
		 }};
	}
	
	public BigDecimal getPorcentagem(DateTime dataVenda) {
		for(TabelaComissionamento tabela : tabelas) {
			if(tabela.isVigente(dataVenda)) return tabela.getPorcentagem();
		}
		return new BigDecimal("0.0");
	}
}
