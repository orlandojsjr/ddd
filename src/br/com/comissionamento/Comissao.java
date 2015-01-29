package br.com.comissionamento;

import java.math.BigDecimal;
import java.util.Calendar;

import br.com.comissionamento.model.Venda;

public interface Comissao {
	BigDecimal calcular(Calendar data, Venda venda);
}
