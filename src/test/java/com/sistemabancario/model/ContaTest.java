package com.sistemabancario.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

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

	@Test
	void testeGetSaldoTotalR06(){
		final double limite = 500;
		final double esperado = limite;
		final Conta instance = new Conta();
		instance.setEspecial(true);
		instance.setLimite(limite);
		final double obtido = instance.getSaldoTotal();

		assertEquals(esperado, obtido);
	}

	@Test
    void depositoDinheiro() {
        final double limite = 500.6, deposito = 500.8, esperado = 1001.4;
        final Conta instance = new Conta();
        instance.setEspecial(true);
        instance.setLimite(limite);
        instance.depositoDinheiro(deposito);
        final double obtido = instance.getSaldoTotal();

        assertEquals(esperado, obtido, 0.001);
    }

    @Test
    void movimentacaoTipoCredito() {
        final Conta instance = new Conta();
        instance.depositoDinheiro(500);
        final List <Movimentacao> movimentacaoLista = instance.getMovimentacoes();
        final Movimentacao movimentacao = movimentacaoLista.get(0);
        final char esperado = 'C';
        final char obtido = movimentacao.getTipo();

        assertEquals(esperado, obtido);
    }


    @Test
    void movimentacaoConfirmacao() {
        final Conta instance = new Conta();
        instance.depositoDinheiro(500);
        final List<Movimentacao> movimentacaoLista = instance.getMovimentacoes();
        final Movimentacao movimentacao = movimentacaoLista.get(0);
        final boolean esperado = true;
        final boolean obtido = movimentacao.isConfirmada();

        assertEquals(esperado, obtido);
    }

    @Test
    void valorMovimentacao() {
        final Conta instance = new Conta();
        instance.depositoDinheiro(500);
        final List<Movimentacao> movimentacaoLista = instance.getMovimentacoes();
        final Movimentacao movimentacao = movimentacaoLista.get(0);
        final double esperado = 500;
        final double obtido = movimentacao.getValor();

        assertEquals(esperado, obtido, 0.001);
    }

    @Test
    void movimentacaoAdd() {
        final Conta instance = new Conta();
        instance.depositoDinheiro(500);
        instance.depositoDinheiro(400);
        final List<Movimentacao> movimentacaoLista = instance.getMovimentacoes();
        final int obtido = movimentacaoLista.size();
        final int esperado = 2;

        assertEquals(esperado, obtido);
    }
}
