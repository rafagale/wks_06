import static org.junit.Assert.*;

import org.junit.Test;

public class TragaBolasTest {

	@Test
	public void testComer() {
		TragaBolas hipo = new TragaBolas(5, 0);
		assertEquals("Ha comido una ñam ñam", hipo.comer());
	}

	@Test
	public void testComer2() {
		TragaBolas hipo = new TragaBolas(5, 5);
		assertEquals("No puedo comer mas necesito dormir", hipo.comer());
	}

	@Test
	public void testTrotar() {
		TragaBolas hipo = new TragaBolas(5, 5);
		assertEquals("Estoy trotando", hipo.trotar());
	}

	@Test
	public void testTrotar2() {
		TragaBolas hipo = new TragaBolas(5, 0);
		assertEquals("Estoy esmirriao no me puedo ni mover", hipo.trotar());
	}

	@Test
	public void testDormir() {
		TragaBolas hipo = new TragaBolas(5, 5);
		assertEquals("Tripa llena. ZZZZZZ", hipo.dormir());
	}

	@Test
	public void testDormir2() {
		TragaBolas hipo = new TragaBolas(5, 0);
		assertEquals("No quiero dormir", hipo.dormir());
	}

	@Test
	public void testGetBolasComidas() {
		TragaBolas hipo = new TragaBolas(5, 2);
		assertEquals(2, hipo.getBolasComidas());
	}

	@Test
	public void testGetMaxBolas() {
		TragaBolas hipo = new TragaBolas(5, 2);
		assertEquals(5, hipo.getMaxBolas());
	}

}
