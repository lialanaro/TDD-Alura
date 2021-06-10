package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;

class BonusServiceTest {

	@Test
	void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
		BonusService service = new BonusService();
		// primeira forma de trabalhar com exepcion. mais limpa 
		//assertThrows(IllegalArgumentException.class,()->service.calcularBonus( new Funcionario("Nathalia", LocalDate.now(), new BigDecimal("25000"))));
		
		//segunda forma com try, voc� pode averiguar a mensagem e tamb�m capturar a exepction pelo console.
		try {
			service.calcularBonus( new Funcionario("Nathalia", LocalDate.now(), new BigDecimal("25000")));
			fail("Erro! N�o deu a expection");
		} catch (Exception e) {
			assertEquals("Funcion�rio com sal�rio alto demais e n�o pode receber bonus", e.getMessage());
		}

	}
	
	@Test
	void bonusDeveriaSerDezPorCentoDoSalario() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus( new Funcionario("Nathalia", LocalDate.now(), new BigDecimal("2500")));
		
		assertEquals(new BigDecimal("250.00"),bonus);
	}
	
	
	@Test
	void bonusDeveriaSerDezPorCentoParaSalarioExatamente10mil() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus( new Funcionario("Nathalia", LocalDate.now(), new BigDecimal("10000")));
		
		assertEquals(new BigDecimal("1000.00"),bonus);
	}


}
