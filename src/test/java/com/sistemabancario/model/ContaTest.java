package com.sistemabancario.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContaTest {

	@Test
	void testSetNumeroValidoR01() {
		final Conta instance = new Conta();
		final String esperado = "12345-6";
		instance.setNumero(esperado);
		final String obtido = instance.getNumero();

		assertEquals(esperado, obtido);
	}

	@Test
	void testSetNumeroInvalidoNaoArmazenaR01() {
		final Conta instance = new Conta();
		final String invalido = "123";

		assertThrows(IllegalArgumentException.class, () -> instance.setNumero(invalido));
		final String obtido = instance.getNumero();

		assertNotEquals(invalido, obtido);
	}

	@Test
	void testSetNumeroNullR01() {
		final Conta instance = new Conta();

		assertThrows(NullPointerException.class, () -> instance.setNumero(null));
	}

	@Test
	void testInstanciaPadraoPoupancaR02() {
		final Conta instance = new Conta();

		assertFalse(instance.isPoupanca());
	}

	@Test
	void testSetLimiteContaEspecialR03() {
		final Conta instance = new Conta();
		instance.setEspecial(true);
		final double esperado = 1000;
		instance.setLimite(esperado);
		final double obtido = instance.getLimite();

		assertEquals(esperado, obtido);
	}

	@Test
	void testSetLimiteContaNaoEspecialR03() {
		final Conta instance = new Conta();
		final double limite = 1000;

		assertThrows(IllegalStateException.class, () -> instance.setLimite(limite));
		final double obtido = instance.getLimite();
		
		assertNotEquals(limite, obtido);
	}

	@Test
	void testHistoricoNotNullR04() {
		final Conta instance = new Conta();

		assertNotNull(instance.getMovimentacoes());
	}
}
