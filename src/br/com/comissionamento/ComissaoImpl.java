package br.com.comissionamento;

import java.math.BigDecimal;

import org.joda.time.DateTime;
import org.joda.time.Days;

import br.com.comissionamento.model.comissionado.Comissionado;
import br.com.comissionamento.model.venda.Venda;

public class ComissaoImpl implements Comissao {
	private static final int MINIMO_DIAS_PAGAR_COMISSAO = 60;
	private DateTime dataCalculo;
	
	public ComissaoImpl(DateTime dataCalculo) {
		this.dataCalculo = dataCalculo;
	}

	public BigDecimal calcular(Venda venda, Comissionado comissionado) {
		
		if(!calculoLiberado(venda.getData())) return new BigDecimal("0");

		return new BigDecimal(venda.getValor().toString()).multiply(comissionado.getPorcentagem(venda.getData()));
	}
	
	private boolean calculoLiberado(DateTime dataVenda) {
		return Days.daysBetween(dataVenda, dataCalculo).getDays() >= MINIMO_DIAS_PAGAR_COMISSAO;
	}
}

