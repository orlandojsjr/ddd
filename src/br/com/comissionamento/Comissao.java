package br.com.comissionamento;

import java.math.BigDecimal;

import br.com.comissionamento.model.TabelaComissionamento;
import br.com.comissionamento.model.Venda;

public interface Comissao {
	BigDecimal calcular(Venda venda, TabelaComissionamento tabelaComissionamento);
}
