package br.com.comissionamento.model.comissionado;

import java.math.BigDecimal;

import org.joda.time.DateTime;


public class Gerente implements Comissionado {

	public BigDecimal getPorcentagem(DateTime dataVenda) {
		return new BigDecimal("0") ;
	}
}
