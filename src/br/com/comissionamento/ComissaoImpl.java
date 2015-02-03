package br.com.comissionamento;

import java.math.BigDecimal;

import org.joda.time.DateTime;
import org.joda.time.Days;

import br.com.comissionamento.model.comissionado.Comissionado;
import br.com.comissionamento.model.comissionado.ComissionadoTipo;
import br.com.comissionamento.model.tabela.TabelaComissionamentoRepository;
import br.com.comissionamento.model.venda.Venda;

public class ComissaoImpl implements Comissao {
	private static final int MINIMO_DIAS_PAGAR_COMISSAO = 60;
	private DateTime dataCalculo;
	
	public ComissaoImpl(DateTime dataCalculo) {
		this.dataCalculo = dataCalculo;
	}

	public BigDecimal calcular(Venda venda, ComissionadoTipo comissionadoTipo) {
		
		if(!calculoLiberado(venda.getData())) return new BigDecimal("0");
		
		Comissionado comissionado = getComissionado(venda.getData(), comissionadoTipo);

		return new BigDecimal(venda.getValor().toString()).multiply(new BigDecimal(comissionado.getPorcentagem().toString()));
	}
	
	private boolean calculoLiberado(DateTime dataVenda) {
		return Days.daysBetween(dataVenda, dataCalculo).getDays() >= MINIMO_DIAS_PAGAR_COMISSAO;
	}
	
	private Comissionado getComissionado(DateTime dataVenda, ComissionadoTipo comissionadoTipo) {
		for (Comissionado comissionado : TabelaComissionamentoRepository.get(dataVenda).getComissionados()) {
			if(comissionado.getTipo() == comissionadoTipo) return comissionado;
		}
		throw new IllegalArgumentException("Comissionado " + comissionadoTipo + " não encontrado na tabela.");
	}
}
