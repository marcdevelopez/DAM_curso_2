package calculadora_junit5;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import junit.framework.TestCase;

public class TestCalculadoraJUnit5 extends TestCase {

	private CalculadoraJUnit5 calculadoraJUnit5;

	/**
	 * Declaramos objeto claculadoraJUnit5 para realizar sobre el los test initarios
	 */
	public void prueba() {
		calculadoraJUnit5 = new CalculadoraJUnit5();
	}

	/**
	 * Y ahora declaramos métodos que coinciden con los declarados en la clase
	 * CalculadoraJUnit5 pero anteponiendo la palabra "test", serán los métodos de
	 * testJUnit: no devuelven nada, sólo haceb la prueba, por eso son void:
	 */
	public void testSumar() {
		prueba();
		assertTrue(calculadoraJUnit5.sumar(2, 2) == (2 + 2));
	}

	public void testRestar() {
		prueba();
		assertEquals(3, calculadoraJUnit5.restar(5, 2));
	}

	public void testMultiplicar() {
		prueba();
		assertTrue(calculadoraJUnit5.multiplicar(2, 2) == (2 * 2));
	}

	public void testDividir() {
		prueba();
		assertTrue(calculadoraJUnit5.dividir(2, 2) == (2 / 2));
	}
}
