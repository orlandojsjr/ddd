package br.com.comissionamento.impl;

import java.math.BigDecimal;

import org.joda.time.Days;

import br.com.comissionamento.Comissao;
import br.com.comissionamento.model.Comissionado;
import br.com.comissionamento.model.TabelaComissionamento;
import br.com.comissionamento.model.Venda;

public class ComissaoImpl implements Comissao {
	private static final int MINIMO_DIAS_PAGAR_COMISSAO = 60;
	
	public BigDecimal calcular(Venda venda, TabelaComissionamento tabelaComissionamento) {
		BigDecimal totalComissao = new BigDecimal("0");
		
		int diasAposVenda = Days.daysBetween(venda.getData(), tabelaComissionamento.getDataCalculo()).getDays();
		if (diasAposVenda < MINIMO_DIAS_PAGAR_COMISSAO) return totalComissao;
		
		for (Comissionado comissionado: tabelaComissionamento.getComissionados()) {
			totalComissao = totalComissao.add(new BigDecimal(venda.getValor().toString()).multiply(new BigDecimal(comissionado.getPorcentagem().toString())));
		}
		return totalComissao;
	}
}
