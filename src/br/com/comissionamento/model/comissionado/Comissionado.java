package br.com.comissionamento.model.comissionado;

import java.math.BigDecimal;

import org.joda.time.DateTime;


public interface Comissionado {
	
	public BigDecimal getPorcentagem(DateTime dataVenda);
}

