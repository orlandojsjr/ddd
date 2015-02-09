package test;

import static junit.framework.Assert.assertEquals;

import java.math.BigDecimal;

import org.joda.time.DateTime;
import org.junit.Test;

import br.com.comissionamento.Comissao;
import br.com.comissionamento.ComissaoImpl;
import br.com.comissionamento.model.comissionado.ComissionadoTipo;
import br.com.comissionamento.model.venda.Venda;

public class ComissaoTest {
	private Comissao comissao;
	
	@Test
	public void Tabela2014VendaDataValida() {
		DateTime dataCalculo = new DateTime(2014, 10, 10, 0, 0);
		DateTime dataVenda = new DateTime(2014, 07, 31, 0, 0);
		comissao =  new ComissaoImpl(dataCalculo);
		Venda venda = new Venda(dataVenda, new Double("100"));
		BigDecimal valorComissaoCorretor = comissao.calcular(venda, ComissionadoTipo.CORRETOR);
		BigDecimal valorComissaoCorretora = comissao.calcular(venda, ComissionadoTipo.CORRETORA);
		BigDecimal valorComissaoGerente = comissao.calcular(venda, ComissionadoTipo.GERENTE_CORRETORA);
		assertEquals(new BigDecimal("2.000"), valorComissaoCorretor);
		assertEquals(new BigDecimal("5.000"), valorComissaoCorretora);
		assertEquals(new BigDecimal("3.000"), valorComissaoGerente);
	}
	
	
	@Test
	public void Tabela2014VendaDataInvalida() {
		DateTime dataCalculo = new DateTime(2014, 10, 10, 0, 0);
		DateTime dataVenda = new DateTime(2014, 12, 9, 0, 0);
		comissao =  new ComissaoImpl(dataCalculo);
		Venda venda = new Venda(dataVenda, new Double("100"));
		BigDecimal valorComissaoCorretor = comissao.calcular(venda, ComissionadoTipo.CORRETOR);
		BigDecimal valorComissaoCorretora = comissao.calcular(venda, ComissionadoTipo.CORRETORA);
		BigDecimal valorComissaoGerente = comissao.calcular(venda, ComissionadoTipo.GERENTE_CORRETORA);
		assertEquals(new BigDecimal("0"), valorComissaoCorretor);
		assertEquals(new BigDecimal("0"), valorComissaoCorretora);
		assertEquals(new BigDecimal("0"), valorComissaoGerente);
	}
	
	@Test
	public void Tabela2015VendaDataValida() {
		DateTime dataCalculo = new DateTime(2015, 4, 1, 0, 0);
		DateTime dataVenda = new DateTime(2015, 1, 1, 0, 0);
		comissao =  new ComissaoImpl(dataCalculo);
		Venda venda = new Venda(dataVenda, new Double("100"));
		BigDecimal valorComissaoCorretor = comissao.calcular(venda, ComissionadoTipo.CORRETOR);
		BigDecimal valorComissaoCorretora = comissao.calcular(venda, ComissionadoTipo.CORRETORA);
		BigDecimal valorComissaoGerente = comissao.calcular(venda, ComissionadoTipo.GERENTE_CORRETORA);
		assertEquals(new BigDecimal("3.000"), valorComissaoCorretor);
		assertEquals(new BigDecimal("4.000"), valorComissaoCorretora);
		assertEquals(new BigDecimal("3.000"), valorComissaoGerente);
	}
	
	@Test 
	public void Tabela2015VendaDataInvalida() {
		DateTime dataCalculo = new DateTime(2015, 01, 2, 0, 0);
		DateTime dataVenda = new DateTime(2015, 1, 1, 0, 0);
		comissao =  new ComissaoImpl(dataCalculo);
		Venda venda = new Venda(dataVenda, new Double("100"));
		BigDecimal valorComissaoCorretor = comissao.calcular(venda, ComissionadoTipo.CORRETOR);
		BigDecimal valorComissaoCorretora = comissao.calcular(venda, ComissionadoTipo.CORRETORA);
		BigDecimal valorComissaoGerente = comissao.calcular(venda, ComissionadoTipo.GERENTE_CORRETORA);
		assertEquals(new BigDecimal("0"), valorComissaoCorretor);
		assertEquals(new BigDecimal("0"), valorComissaoCorretora);
		assertEquals(new BigDecimal("0"), valorComissaoGerente);
	}
}

