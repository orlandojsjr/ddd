package test;

import static junit.framework.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Arrays;

import org.joda.time.DateTime;
import org.junit.Test;

import br.com.comissionamento.Comissao;
import br.com.comissionamento.impl.ComissaoImpl;
import br.com.comissionamento.model.Comissionado;
import br.com.comissionamento.model.ComissionadoTipo;
import br.com.comissionamento.model.TabelaComissionamento;
import br.com.comissionamento.model.Venda;

public class ComissaoTest {
	private Comissao comissao = new ComissaoImpl();;
	
	private TabelaComissionamento tabelaComissionamento1 = new TabelaComissionamento(new DateTime(2014, 3, 25, 0, 0), Arrays.asList(
			new Comissionado(new Double("0.05"), ComissionadoTipo.CORRETORA), 
			new Comissionado(new Double("0.03"), ComissionadoTipo.GERENTE_CORRETORA), 
			new Comissionado(new Double("0.02"), ComissionadoTipo.CORRETOR)
	));
		
	private TabelaComissionamento tabelaComissionamento2 = new TabelaComissionamento(new DateTime(2014, 3, 25, 0, 0), Arrays.asList(
			new Comissionado(new Double("0.04"), ComissionadoTipo.CORRETORA), 
			new Comissionado(new Double("0.03"), ComissionadoTipo.GERENTE_CORRETORA), 
			new Comissionado(new Double("0.03"), ComissionadoTipo.CORRETOR)
	));
	
	
	@Test
	@SuppressWarnings("deprecation")
	public void Tabela1ComComissao() {
		Venda vendaComComissao = new Venda(new DateTime(2013, 12, 31, 0, 0), new Double("100"));
		BigDecimal valorComissao = comissao.calcular(vendaComComissao, tabelaComissionamento1);
		assertEquals(new BigDecimal("10.000"), valorComissao);
	}
	
	@Test
	@SuppressWarnings("deprecation")
	public void Tabela1SemComissao() {
		Venda vendaSemComissao = new Venda(new DateTime(2014, 03, 01, 0, 0), new Double("100"));
		BigDecimal valorComissao = comissao.calcular(vendaSemComissao, tabelaComissionamento1);
		assertEquals(new BigDecimal("0"), valorComissao);
	}
	
	@Test 
	@SuppressWarnings("deprecation")
	public void Tabela2ComComissao() {
		Venda vendaComComissaoTbl2 = new Venda(new DateTime(2014, 01, 01, 0, 0), new Double("100"));
		BigDecimal valorComissao = comissao.calcular(vendaComComissaoTbl2, tabelaComissionamento2);
		assertEquals(new BigDecimal("10.000"), valorComissao);
	}
	
	@Test 
	@SuppressWarnings("deprecation")
	public void Tabela2SemComissao() {
		Venda vendaSemComissao = new Venda(new DateTime(2014, 03, 01, 0, 0), new Double("100"));
		BigDecimal valorComissao = comissao.calcular(vendaSemComissao, tabelaComissionamento2);
		assertEquals(new BigDecimal("0"), valorComissao);
	}
}
