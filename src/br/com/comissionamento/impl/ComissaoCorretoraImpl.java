package br.com.comissionamento.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;

import br.com.comissionamento.Comissao;
import br.com.comissionamento.model.Venda;

public class ComissaoCorretoraImpl implements Comissao {

	public BigDecimal calcular(Calendar data, Venda venda) {
		return  venda.getValor().multiply(new BigDecimal("0.05"));
	}

}
