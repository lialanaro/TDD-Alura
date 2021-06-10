package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

public class ReajusteServiceTeste {
	private ReajusteService service;
	private Funcionario funcionario;
	
	//antes de cada m�todo inicializar 
	@BeforeEach
	public void inicializar() {
		service = new ReajusteService();
		funcionario = new Funcionario("Nathalia", LocalDate.now(), new BigDecimal("1000.00"));
		
	}

	@Test
	public void reajusteDeveriaSerDe3porCentoQuandoDesepenhoForAdesejar() {
		service.ConcederReajuste(funcionario,Desempenho.A_DESEJAR);
		assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
		
	}
	
	@Test
	public void reajusteDeveriaSerDe3porCentoQuandoDesepenhoForBom() {
		service.ConcederReajuste(funcionario,Desempenho.BOM);
		assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
		
	}
	
	@Test
	public void reajusteDeveriaSerDe3porCentoQuandoDesepenhoForOtimo() {
		service.ConcederReajuste(funcionario,Desempenho.OTIMO);
		assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
		
	}
}
