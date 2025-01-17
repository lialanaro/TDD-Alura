package br.com.alura.tdd.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.alura.tdd.modelo.Funcionario;

public class BonusService {

	public BigDecimal calcularBonus(Funcionario funcionario) {
		BigDecimal valor = funcionario.getSalario().multiply(new BigDecimal("0.1"));
		if (valor.compareTo(new BigDecimal("1000")) > 0) {
			throw new IllegalArgumentException("Funcion�rio com sal�rio alto demais e n�o pode receber bonus");
		}
		//m�todo para colocar duas casas decimais e arrendondar para cima.
		return valor.setScale(2, RoundingMode.HALF_UP);
	}

}
