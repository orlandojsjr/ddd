package br.com.comissionamento;

import java.math.BigDecimal;

import br.com.comissionamento.model.comissionado.ComissionadoTipo;
import br.com.comissionamento.model.venda.Venda;

public interface Comissao {
	BigDecimal calcular(Venda venda, ComissionadoTipo ComissionadoTipo);
}

