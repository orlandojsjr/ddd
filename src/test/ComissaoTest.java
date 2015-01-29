package test;

import java.math.BigDecimal;
import java.util.Calendar;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import br.com.comissionamento.Comissao;
import br.com.comissionamento.impl.ComissaoCorretoraImpl;
import br.com.comissionamento.model.Venda;

public class ComissaoTest {
	private Calendar dataAte = Calendar.getInstance();
	private Calendar dateAPartir = Calendar.getInstance();
	private BigDecimal valorVenda;
	
	@Before
	public void inicialize() {
		dataAte.set(2014, 12, 31);
		dateAPartir.set(2015, 01, 01);
		valorVenda = new BigDecimal("100");
	}
	
	@Test
	public void testeCorretora() {
		Comissao comissao = new ComissaoCorretoraImpl();
		Venda venda = new Venda(dataAte, valorVenda);
		BigDecimal valorComissao = comissao.calcular(dataAte, venda);
		Assert.assertEquals(new BigDecimal("5.00"), valorComissao);
	}
}
