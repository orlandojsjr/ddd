package test;

import static junit.framework.Assert.assertEquals;

import java.math.BigDecimal;

import org.joda.time.DateTime;
import org.junit.Test;

import br.com.comissionamento.Calculadora;
import br.com.comissionamento.CalculadoraImpl;
import br.com.comissionamento.model.comissionado.Corretor;
import br.com.comissionamento.model.comissionado.Corretora;
import br.com.comissionamento.model.comissionado.Gerente;
import br.com.comissionamento.model.venda.Venda;

public class ComissaoTest {
	private Calculadora calculadora;
	
	@Test
	public void Tabela2014VendaDataValida() {
		DateTime dataCalculo = new DateTime(2014, 10, 10, 0, 0);
		DateTime dataVenda = new DateTime(2014, 07, 31, 0, 0);
		calculadora =  new CalculadoraImpl(dataCalculo);
		Venda venda = new Venda(dataVenda, new BigDecimal("100"));
		BigDecimal valorComissaoCorretor = calculadora.calcular(venda, new Corretor());
		BigDecimal valorComissaoCorretora = calculadora.calcular(venda, new Corretora());
		BigDecimal valorComissaoGerente = calculadora.calcular(venda, new Gerente());
		assertEquals(new BigDecimal("2.00"), valorComissaoCorretor);
		assertEquals(new BigDecimal("5.00"), valorComissaoCorretora);
		assertEquals(new BigDecimal("3.00"), valorComissaoGerente);
	}
	
	
	@Test
	public void Tabela2014VendaDataInvalida() {
		DateTime dataCalculo = new DateTime(2014, 10, 10, 0, 0);
		DateTime dataVenda = new DateTime(2014, 12, 9, 0, 0);
		calculadora =  new CalculadoraImpl(dataCalculo);
		Venda venda = new Venda(dataVenda, new BigDecimal("100"));
		BigDecimal valorComissaoCorretor = calculadora.calcular(venda, new Corretor());
		BigDecimal valorComissaoCorretora = calculadora.calcular(venda, new Corretora());
		BigDecimal valorComissaoGerente = calculadora.calcular(venda, new Gerente());
		assertEquals(new BigDecimal("0"), valorComissaoCorretor);
		assertEquals(new BigDecimal("0"), valorComissaoCorretora);
		assertEquals(new BigDecimal("0"), valorComissaoGerente);
	}
	
	@Test
	public void Tabela2015VendaDataValida() {
		DateTime dataCalculo = new DateTime(2015, 4, 1, 0, 0);
		DateTime dataVenda = new DateTime(2015, 1, 1, 0, 0);
		calculadora =  new CalculadoraImpl(dataCalculo);
		Venda venda = new Venda(dataVenda, new BigDecimal("100"));
		BigDecimal valorComissaoCorretor = calculadora.calcular(venda, new Corretor());
		BigDecimal valorComissaoCorretora = calculadora.calcular(venda, new Corretora());
		BigDecimal valorComissaoGerente = calculadora.calcular(venda, new Gerente());
		assertEquals(new BigDecimal("3.00"), valorComissaoCorretor);
		assertEquals(new BigDecimal("4.00"), valorComissaoCorretora);
		assertEquals(new BigDecimal("3.00"), valorComissaoGerente);
	}
	
	@Test 
	public void Tabela2015VendaDataInvalida() {
		DateTime dataCalculo = new DateTime(2015, 01, 2, 0, 0);
		DateTime dataVenda = new DateTime(2015, 1, 1, 0, 0);
		calculadora =  new CalculadoraImpl(dataCalculo);
		Venda venda = new Venda(dataVenda, new BigDecimal("100"));
		BigDecimal valorComissaoCorretor = calculadora.calcular(venda, new Corretor());
		BigDecimal valorComissaoCorretora = calculadora.calcular(venda, new Corretora());
		BigDecimal valorComissaoGerente = calculadora.calcular(venda, new Gerente());
		assertEquals(new BigDecimal("0"), valorComissaoCorretor);
		assertEquals(new BigDecimal("0"), valorComissaoCorretora);
		assertEquals(new BigDecimal("0"), valorComissaoGerente);
	}
}
