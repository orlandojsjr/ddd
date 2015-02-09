package br.com.comissionamento.model.tabela;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.joda.time.DateTime;

import br.com.comissionamento.model.comissionado.Comissionado;
import br.com.comissionamento.model.comissionado.ComissionadoTipo;

public class TabelaComissionamentoRepository {
	
	public static final List<TabelaComissionamento> tabelas;
	private static final DateTime dataCorte = new DateTime(2014, 12, 31, 0, 0);
	
	static {
		 tabelas =  new ArrayList<TabelaComissionamento>() {{
			 // tabela 2014
			 add(new TabelaComissionamento(Arrays.asList(
					new Comissionado(new BigDecimal("0.05"), ComissionadoTipo.CORRETORA), 
					new Comissionado(new BigDecimal("0.03"), ComissionadoTipo.GERENTE_CORRETORA), 
					new Comissionado(new BigDecimal("0.02"), ComissionadoTipo.CORRETOR))));
			 
			 // tabela 2015
			 add(new TabelaComissionamento(Arrays.asList(
						new Comissionado(new BigDecimal("0.04"), ComissionadoTipo.CORRETORA), 
						new Comissionado(new BigDecimal("0.03"), ComissionadoTipo.GERENTE_CORRETORA), 
						new Comissionado(new BigDecimal("0.03"), ComissionadoTipo.CORRETOR))));
		 }};
	}
	
	private static TabelaComissionamento getTabela(DateTime dataVenda) {
		return dataVenda.isAfter(dataCorte) ? tabelas.get(1) : tabelas.get(0);
	}
	
	public static BigDecimal getPorcentagem(DateTime dataVenda, ComissionadoTipo comissionadoTipo) {
		for (Comissionado comissionado : getTabela(dataVenda).getComissionados()) {
			if(comissionado.getTipo() == comissionadoTipo) return comissionado.getPorcentagem();
		}
		throw new IllegalArgumentException("Comissionado " + comissionadoTipo + " não encontrado na tabela.");
	}
}

