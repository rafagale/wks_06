import static org.junit.Assert.*;

import org.junit.Test;

public class CalculadoraTest {



	@Test
	public void testSuma() {
		int a=1, b=1;
		Calculadora calcu = new Calculadora(a, b);
		int resultado = calcu.suma();
		assertEquals(resultado, 2);
	}

	@Test
	public void testResta() {
		fail();
	}

	@Test
	public void testmulti() {
		fail();
	}

	@Test
	public void testDivide() {
		fail();
	}

}