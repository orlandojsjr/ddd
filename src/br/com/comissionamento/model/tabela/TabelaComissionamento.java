package br.com.comissionamento.model.tabela;

import java.math.BigDecimal;

import org.joda.time.DateTime;

public class TabelaComissionamento {
	
	private BigDecimal porcentagem;
	private PeriodoVigencia periodoVigencia;
	
	public TabelaComissionamento(BigDecimal porcentagem, PeriodoVigencia periodoVigencia) {
		this.porcentagem = porcentagem;
		this.periodoVigencia = periodoVigencia;
	}

	public BigDecimal getPorcentagem() {
		return porcentagem;
	}

	public boolean isVigente(DateTime dataVenda) {
		return periodoVigencia.isVigente(dataVenda);
	}
}

