package br.com.comissionamento.model.tabela;

import org.joda.time.DateTime;
import org.joda.time.Interval;

public class PeriodoVigencia {
	
	private Interval periodo;
	
	public PeriodoVigencia(DateTime inicio, DateTime fim) {
		periodo = new Interval(inicio, fim);
	}

	public boolean isVigente(DateTime data) {
		return periodo.contains(data);
	}
}
